package totoro;

import java.util.Vector;

/**
 * ��������Ĺ���
 * @author jackey
 *
 */
public class MoveObjectFactory {

	private MoveObjectFactory(){}
	private static MoveObjectFactory instance;
	public static MoveObjectFactory getInstance(){
		if(instance==null){
			instance = new MoveObjectFactory();
		}
		return instance;
	}
	
	public Vector bombs = new Vector();
	public Vector spirits = new Vector();
	
	/*�������*/
	private int playerParam[][] = {
			/*0-id, 1-x����, 2-y����, 3-���, 4-�߶�, 5-������, 6-Ѫ��, 7-�˺�, 8-�ȼ�, 9-x�ٶ�, 10-y�ٶ�*/
			{0, 20, 250, 37, 76, 3, 200, 10, 1, 10, 10},
	};
	
	/*�����ͨ��������*/
	private int bombParam[][] = {
			/*0-id, 1-���, 2-�߶�, 3-�˺�, 4-x�ٶ�, 5-Y�ٶ�*/
			{10, 27, 21, 10, 20, 20},
	};
	
	/*��������*/
	private int spiritParam[][] = {
			/*0-id, 1-���, 2-�߶�, 3-Ѫ��, 4-����, 5-x�ٶ�, 6-y�ٶ�, 7-x����, 8-y����*/
			{100, 47, 62, 1, 100, 10, 10, 640, 200, },
	};
	
	/*������ͨ����*/
	public void createSpirits(int level){
		
	}
	
	/*���������ͨ����*/
	public void createBomb(MoveObject player){
		MoveObject object = new MoveObject();
		object.id = bombParam[0][0];
		object.width = bombParam[0][1];
		object.height = bombParam[0][2];
		object.damage = bombParam[0][3];
		object.speedX = bombParam[0][4];
		object.speedY = bombParam[0][5];
		object.grade = player.grade;
		object.mapx = player.mapx+player.width;
		object.mapy = player.mapy+player.height/2-object.height/2;
		bombs.addElement(object);
	}
	 
	/**
	 * ��������Ϸ���
	 * @return
	 */
	public MoveObject createNewPlayer(){
		MoveObject object = new MoveObject();
		object.id = playerParam[0][0];
		object.mapx = playerParam[0][1];
		object.mapy = playerParam[0][2];
		object.width = playerParam[0][3];
		object.height = playerParam[0][4];
		object.lifeNum = playerParam[0][5];
		object.blood = playerParam[0][6];
		object.damage = playerParam[0][7];
		object.grade = playerParam[0][8];
		object.speedX = playerParam[0][9];
		object.speedY = playerParam[0][10];
		return object;
	}
}
