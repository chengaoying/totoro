package totoro;

/*
 * ���������� 
 */
public interface Common {
	
	public final static int STATUS_INIT = 0;			//��ʼ
	public final static int STATUS_MAIN_MENU = 1;		//��Ϸ���˵� 
	public final static int STATUS_GAME_PLAYING = 2;	//��Ϸ��
	public final static int STATUS_GAME_RECHARGE = 3;	//��Ϸ��

	public final static int ScrW = TotoroGameEngine.ScrW;
	public final static int ScrH = TotoroGameEngine.ScrH;
	public final static int gameW = 490;				//��Ϸ������
}
