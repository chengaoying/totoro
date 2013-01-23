package totoro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;

import cn.ohyeah.itvgame.model.GameAttainment;
import cn.ohyeah.itvgame.model.GameRanking;
import cn.ohyeah.itvgame.model.GameRecord;
import cn.ohyeah.stb.game.GameCanvasEngine;
import cn.ohyeah.stb.game.SGraphics;
import cn.ohyeah.stb.game.ServiceWrapper;
import cn.ohyeah.stb.key.KeyCode;
import cn.ohyeah.stb.key.KeyState;
import cn.ohyeah.stb.util.DateUtil;

/**
 * ��Ϸ����
 * @author Administrator
 */
public class TotoroGameEngine extends GameCanvasEngine implements Common {
	public static boolean isSupportFavor = false;
	public static int ScrW = 0;
	public static int ScrH = 0;
	
	public static TotoroGameEngine instance = buildGameEngine();

	private static TotoroGameEngine buildGameEngine() {
		if(instance==null){
			return new TotoroGameEngine(TotoroMIDlet.getInstance());
		}else{
			return instance;
		}
	}

	public StateMain stateMain;
	public StateGame stateGame;
	public StateSelectInterface stateSelect;
	public PropManager pm;
	private int recordId;
	public static boolean result;
	
	private TotoroGameEngine(MIDlet midlet) {
		super(midlet);
		setRelease(false);
		ScrW = screenWidth;
		ScrH = screenHeight;
		stateGame = new StateGame(this);
		stateMain = new StateMain(this);
		stateSelect = new StateSelectInterface(this);
		pm = new PropManager(this);
	}

	public int state;
	public int mainIndex, playingIndex;
	private int cursorFrame;
	public PlayerProp[] props;
	public GameRanking[] rankList;
	
	protected void loop() {
		
		/*��ʾ����*/
		switch (state) {
		case STATUS_INIT:
			showInit(g);
			break;
		case STATUS_MAIN_MENU:
			stateMain.show(g);
			break;
		case STATUS_SELECT_TOTORO:
			stateSelect.show(g);
			break;
		case STATUS_GAME_PLAYING:
			stateGame.show(g);
			break;
		}
		
		/*ִ���߼�*/
		switch (state) {
		case STATUS_INIT:
			cursorFrame = (cursorFrame+1)%12;
			break;
		case STATUS_MAIN_MENU:
			stateMain.execute();
			break;
		case STATUS_SELECT_TOTORO:
			stateSelect.execute();
			break;
		case STATUS_GAME_PLAYING:
			stateGame.execute();
			break;
		}
		
		/*�����ֵ*/
		switch (state) {   	
		case STATUS_INIT:
			handleInit(keyState);
			break;
		case STATUS_MAIN_MENU: 
			stateMain.handleKey(keyState);
			break;
		case STATUS_SELECT_TOTORO:
			stateSelect.handle(keyState);
			break;
		case STATUS_GAME_PLAYING:
			stateGame.handleKey(keyState);
			break;
		}
		
		/*�˳���Ϸ*/
		exit();
	}
	
	private void init() {
		/*��ѯ����*/
		pm.queryProps();
		
		setRecordId();
		
		/*��ѯ����*/
		queryList();
		
		if(pm.getPropNumsById(65)>0){
			StateGame.wingplaneMaxNums = 4;
		}else if(pm.getPropNumsById(64)>0){
			StateGame.wingplaneMaxNums = 3;
		}else if(pm.getPropNumsById(63)>0){
			StateGame.wingplaneMaxNums = 2;
		}else{
			StateGame.wingplaneMaxNums = 1;
		}
		StateGame.ventoseNum = pm.getPropNumsById(66);
		StateGame.hasTotoro3 = pm.getPropNumsById(61)>0?true:false;
		StateGame.hasTotoro4 = pm.getPropNumsById(62)>0?true:false;
		
		/*��ȡ��Ϸ��¼*/
		readRecord();
	}
	
	private void queryList() {
		ServiceWrapper sw = getServiceWrapper();
		rankList = sw.queryRankingList(0, 10);
	}

	private void handleInit(KeyState key) {
		if(key.containsAndRemove(KeyCode.OK)){
			state = STATUS_MAIN_MENU;
			init();
			Resource.clearInit();
		}
	}


	private void showInit(SGraphics g) {
		Image bg = Resource.loadImage(Resource.id_bg);
		Image text = Resource.loadImage(Resource.id_text);
		g.drawImage(bg, 0, 0, 20);
		if(cursorFrame>4){
			int x = screenWidth/2 - text.getWidth()/2;
			g.drawImage(text, x, 495, 20);
		}
	}


	private void exit(){
		if(stateMain.exit){
			exit = true;
		}
	}
	
	private long recordTime;
	public boolean timePass(int millisSeconds) {
		long curTime = System.currentTimeMillis();
		if (recordTime <= 0) {
			recordTime = curTime;
		}
		else {
			if (curTime-recordTime >= millisSeconds) {
				recordTime = 0;
				return true;
			}
		}
		return false;
	}
	
	private void setRecordId(){
		Date date = new Date(getEngineService().getCurrentTime().getTime());
	    int year = DateUtil.getYear(date);
		int month = DateUtil.getMonth(date);
	    recordId = year*100+(month+1);
	    //attainmentId = year*100+(month+1);
	    System.out.println("GetServiceDate: Date=" + date);
	    System.out.println("GetServiceDate: Date=" + recordId);
	}
	
	public void sysProps(){
		pm.sysProps();
	}
	
	public void saveRecord(){
		
		queryList();
		
		if(StateGame.lifeNum<1 || StateGame.scores<=0){
			return;
		}
		
		byte record[];
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		DataOutputStream dout = new DataOutputStream(bout);
		ServiceWrapper sw = getServiceWrapper();
		try {
			setRecordData(dout);
			record = bout.toByteArray();
			GameRecord gameRecord = new GameRecord();
			gameRecord.setData(record);
			gameRecord.setScores(StateGame.scores);
			//gameRecord.setPlayDuration(StateGame.scores);
			gameRecord.setRemark("�浵");
			gameRecord.setRecordId(recordId);
			sw.saveRecord(gameRecord);
		} catch (Exception e) {
			System.out.println("������Ϸʧ�ܣ�ԭ��"+e.getMessage());
			//state = STATUS_MAIN_MENU;
		} finally{
			try {
				dout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				try {
					bout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public void saveAttainment(){
		byte record[];
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		DataOutputStream dout = new DataOutputStream(bout);
		ServiceWrapper sw = getServiceWrapper();
		GameAttainment ga = sw.readAttainment(recordId);
		if(ga!=null && ga.getScores()>=StateGame.scores){
			return;
		}
		try {
			//setRecordData(dout);
			record = bout.toByteArray();
			GameAttainment gameAttainment = new GameAttainment();
			gameAttainment.setData(record);
			gameAttainment.setScores(StateGame.scores);
			gameAttainment.setRemark("��ɾ�");
			gameAttainment.setAttainmentId(recordId);
			sw.saveAttainment(gameAttainment);
		} catch (Exception e) {
			System.out.println("����ɾ�ʧ�ܣ�ԭ��"+e.getMessage());
			//state = STATUS_MAIN_MENU;
		} finally{
			try {
				dout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				try {
					bout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	private void setRecordData(DataOutputStream dout) throws IOException{
		dout.write(StateGame.lifeNum);
		dout.write(StateGame.currLevel);
		dout.write(StateGame.blood);
		dout.write(StateGame.grade);
		dout.write(StateGame.bombGrade);
		//dout.write(StateGame.wingplaneMaxNums);
		dout.write(StateGame.wingplaneNums);
		dout.write(StateGame.missileGrade);
		dout.write(StateGame.batchIndex);
		//dout.write(StateGame.ventoseNum);
		//dout.writeBoolean(StateGame.hasTotoro3);
		//dout.writeBoolean(StateGame.hasTotoro4);
		
		printInfo();
	}
	
	public boolean readRecord(){
		ServiceWrapper sw = getServiceWrapper();
		GameRecord gameRecord = sw.readRecord(recordId);
		if(!sw.isServiceSuccessful() || gameRecord==null){
			return result = false;
		}
		ByteArrayInputStream bin = new ByteArrayInputStream(gameRecord.getData());
		DataInputStream din = new DataInputStream(bin);
		try {
			initRecordInfo(din);
			StateGame.scores = gameRecord.getScores();
			return result = true;
		} catch (Exception e) {
			System.out.println("��ȡ��Ϸʧ�ܣ�ԭ��"+e.getMessage());
			state = STATUS_MAIN_MENU;
			return result = false;
		}finally{
			try {
				din.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				try {
					bin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void initRecordInfo(DataInputStream din) throws IOException {
		StateGame.lifeNum = din.read();
		StateGame.currLevel = din.read();
		StateGame.blood = din.read();
		StateGame.grade = din.read();
		StateGame.bombGrade = din.read();
		StateGame.wingplaneNums = din.read();
		StateGame.missileGrade = din.read();
		StateGame.batchIndex = din.read();
		
		printInfo();
	}

	private void printInfo(){
		System.out.println("StateGame.lifeNum:"+StateGame.lifeNum);
		System.out.println("StateGame.currLevel:"+StateGame.currLevel);
		System.out.println("StateGame.blood:"+StateGame.blood);
		System.out.println("StateGame.grade:"+StateGame.grade);
		System.out.println("StateGame.bombGrade:"+StateGame.bombGrade);
		System.out.println("StateGame.wingplaneMaxNums:"+StateGame.wingplaneMaxNums);
		System.out.println("StateGame.wingplaneNums:"+StateGame.wingplaneNums);
		System.out.println("StateGame.missileGrade:"+StateGame.missileGrade);
		System.out.println("StateGame.batchIndex:"+StateGame.batchIndex);
		System.out.println("StateGame.ventoseNum:"+StateGame.ventoseNum);
		System.out.println("StateGame.hasTotoro3:"+StateGame.hasTotoro3);
		System.out.println("StateGame.hasTotoro4:"+StateGame.hasTotoro4);
		System.out.println("StateGame.scores:"+StateGame.scores);
	}
}
