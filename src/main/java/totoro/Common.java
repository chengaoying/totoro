package totoro;

/*
 * ���������� 
 */
public interface Common {
	
	public final static int STATUS_INIT = 0;			//��ʼ
	public final static int STATUS_MAIN_MENU = 1;		//��Ϸ���˵� 
	public final static int STATUS_GAME_PLAYING = 2;	//��Ϸ��

	public final static int ScrW = TotoroGameEngine.ScrW;
	public final static int ScrH = TotoroGameEngine.ScrH;
	public final static int gameH = 490/*444*/;
	public final static int startP = 0/*46*/;
	public final static int endP = 490;

	public final static int spirit_id = 100;
	public final static int boss_id = 200;
	
	/*�����ʼλ��*/
	public static final int OBJECT_POSITION_UP = 1;			//��	
	public static final int OBJECT_POSITION_DOWN = 2;		//��
	public static final int OBJECT_POSITION_LEFT = 3;		//��
	public static final int OBJECT_POSITION_RIGHT = 4;		//��
	
	/*�����ƶ�����*/
	public static final int OBJECT_DIRECTION_UP = 0;			//��
	public static final int OBJECT_DIRECTION_DOWN = 1;			//��
	public static final int OBJECT_DIRECTION_LEFT = 2;			//��
	public static final int OBJECT_DIRECTION_RIGHT = 3;			//��
	public static final int OBJECT_DIRECTION_LEFT_UP = 4;			//����
	public static final int OBJECT_DIRECTION_RIGHT_UP = 5;			//����
	public static final int OBJECT_DIRECTION_LEFT_DOWN = 6;			//����
	public static final int OBJECT_DIRECTION_RIGHT_DOWN = 7;		//����
	
	/*���鹥��״̬*/
	public static final int ATTACK_PERMISSION_YES = 1;	//�ܹ���
	public static final int ATTACK_PERMISSION_NO = 0;	//���ܹ���
	
	/*���������Ƿ����佱Ʒ*/
	public static final int SPIRITI_PRIZE_YES = 1;		//��
	public static final int SPIRITI_PRIZE_NO = 0;		//����
	
	/*��ɫ״̬1*/
	public static final int ROLE_STATUS_ALIVE = 1;		//����״̬
	public static final int ROLE_STATUS_DEAD = -1;		//����ת̨	
	public static final int ROLE_STATUS_PROTECTED = 2;	//�޵�״̬
	public static final int ROLE_STATUS_PASS = 3;		//ͨ��״̬
	
	/*��ɫ״̬2*/
	public static final int ROLE_STATUS2_MOVE = 1;			//�ƶ�״̬
	public static final int ROLE_STATUS2_ATTACK = 2;		//��ͨ����״̬
	public static final int ROLE_STATUS2_SKILL_ATTACK = 3;	//���ܹ���״̬
	
	/*���ͼƬid*/
	public static final int player1PicId = Resource.id_own_totoro1;
	
	/*�ӵ�ͼƬid*/
	public static final int bomb1PicId = Resource.id_own_totoro1_bomb;

	/*�����ӵ�ͼƬ*/
	public static final int spiritBomb1PicId = Resource.id_sky_spirit_bomb_1;
	public static final int bossBomb1PicId = Resource.id_sky_boss_bomb_1;
	public static final int bossBomb2PicId = Resource.id_sky_boss_bomb_2;
	
	/*����ͼƬid*/
	public static final int spirits_1 = Resource.id_sky_spirits_1;
	public static final int spirits_2 = Resource.id_sky_spirits_2;
	public static final int spirits_3 = Resource.id_sky_spirits_3;
	
	/*��̨ͼƬid*/
	public static final int battery_1 = Resource.id_sky_battery;
	
	/*bossͼƬid*/
	public static final int boss_1 = Resource.id_sky_boss_1;
	public static final int boss_2 = Resource.id_sky_boss_2;
	
	/*�ؿ��ȼ���Ϣ*/
	public static final int levelInfo[][] = {
		/*0-�ؿ�, 1-�ؿ�ʱ��(��), 2-����ʱ����, 3-battery interval*/
		{1, 10, 3000, 10000},
		{2, 10, 3000, 10000},
		{3, 10, 3000, 10000},
		{4, 10, 3000, 10000},
		{5, 10, 3000, 10000},
		{6, 10, 3000, 10000},
		{7, 10, 3000, 10000},
		{8, 10, 3000, 10000},
	};
	
	/*�������*/
	public int playerParam[][] = {
			/*0-id, 1-x����, 2-y����, 3-���, 4-�߶�, 5-������, 6-Ѫ��, 7-�˺�, 8-�ȼ�, 9-x�ٶ�, 10-y�ٶ�
			 * ,11-����ӵ��ȼ�, 12-���ͼƬid*/
			{0, 20, 250, 37, 76, 3, 150, 50, 1, 10, 10, 1, player1PicId},
	};
	
	/*�����ͨ��������*/
	public int bombParam[][][] = {
			/*��ҵȼ�*/
			{
				/*�ӵ��ȼ�*/
				/*0-id, 1-���, 2-�߶�, 3-�˺�, 4-x�ٶ�, 5-Y�ٶ�, 6-�ӵ�ͼƬid*/
				{10, 27, 21, 10, 20, 20, bomb1PicId},
			},
	};
	
	/*boss����*/
	public int bossParam[][] = {
			/*0-id, 1-���, 2-�߶�, 3-Ѫ��, 4-����, 5-x�ٶ�, 6-y�ٶ�, 7-x����, 8-y����
			 * 9-ͼƬid, 10-֡�����, 11-ͼƬ��֡��, 12-�˺�, 13-�����ӵ����, 14-����, 15-��ʼλ��*/
			{200, 186, 266, 100/*9000*/, 100, 5, 5, 0, 0, boss_1, 300, 5, 50, 1, OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT},
			{201, 356, 462, 100/*9000*/, 100, 5, 5, 0, 0, boss_2, 300, 3, 50, 1, OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT},
			{202, 356, 462, 100/*9000*/, 100, 5, 5, 0, 0, boss_2, 300, 3, 50, 1, OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT},
			{203, 356, 462, 100/*9000*/, 100, 5, 5, 0, 0, boss_2, 300, 3, 50, 1, OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT},
			{204, 356, 462, 100/*9000*/, 100, 5, 5, 0, 0, boss_2, 300, 3, 50, 1, OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT},
			{205, 356, 462, 100/*9000*/, 100, 5, 5, 0, 0, boss_2, 300, 3, 50, 1, OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT},
			{206, 356, 462, 100/*9000*/, 100, 5, 5, 0, 0, boss_2, 300, 3, 50, 1, OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT},
			{207, 356, 462, 100/*9000*/, 100, 5, 5, 0, 0, boss_2, 300, 3, 50, 1, OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT},
	};
	

	/*��̨����*/
	public int batteryParam[][] = {
			/*0-id, 1-width, 2-height, 3-blood, 4-scores, 5-speedX, 6-speedY, 7-coorX, 8-coorY
			 * 9-position, 10-attackpermission, 11-picId, 12-frameNum, 13-damage, 14-bombInterval*/
			{300, 70, 69, 50, 30, 2, 0, ScrW, 423, OBJECT_POSITION_LEFT, ATTACK_PERMISSION_YES, battery_1, 3, 10, 2},
			{300, 70, 69, 50, 30, 2, 0, ScrW, 423, OBJECT_POSITION_LEFT, ATTACK_PERMISSION_YES, battery_1, 3, 10, 2},
	};
	
	/*������ͨ��������*/
	public int spiritBombParam[][] = {
			/*0-����id, 1-id, 2-���, 3-�߶�, 4-�˺�, 5-x�ٶ�, 6-Y�ٶ�, 7-�ӵ�ͼƬid*/
			{100, 15, 20, 19, 25, 20, 20, spiritBomb1PicId},
			{200, 16, 85, 50, 25, 20, 20, bossBomb1PicId},
			{201, 17, 85, 50, 25, 20, 20, bossBomb2PicId},
			{202, 18, 85, 50, 25, 20, 20, bossBomb2PicId},
			{203, 19, 85, 50, 25, 20, 20, bossBomb2PicId},
			{204, 20, 85, 50, 25, 20, 20, bossBomb2PicId},
			{205, 21, 85, 50, 25, 20, 20, bossBomb2PicId},
			{206, 22, 85, 50, 25, 20, 20, bossBomb2PicId},
			{300, 15, 20, 19, 25, 20, 10, spiritBomb1PicId},
	};
	
	/*��������*/
	public int spiritParam[][] = {
	/*0-id, 1-���, 2-�߶�, 3-Ѫ��, 4-����, 5-x�ٶ�, 6-y�ٶ�, 7-x����, 8-y����, 9-��ʼλ��, 
	 * 10-�Ƿ�ṥ��, 11-ͼƬid, 12-�Ƿ����佱Ʒ, 13-֡�����, 14-ͼƬ��֡�� , 15-�����˺�
	 * 16-�����ӵ����*/
		{100, 47, 62, 1, 100, 6, 6, 640, 200, 0, ATTACK_PERMISSION_YES, spirits_1, SPIRITI_PRIZE_NO, 500, 5, 10, 5},
		{101, 84, 76, 1, 100, 8, 8, 640, 200, 0, ATTACK_PERMISSION_NO, spirits_2, SPIRITI_PRIZE_NO, 500, 3, 10, 0},
		{102, 80, 62, 100, 100, 6, 6, 640, 200, 0, ATTACK_PERMISSION_NO, spirits_3, SPIRITI_PRIZE_NO, 500, 3, 10, 3},
	};
	
	/*����������Ϣ*/
	public int batchInfo[][][] = {
			/*0-id, 1-����, 2-��ʼλ��, 3-�ƶ�����*/
		/*��һ�ع����б�*/	
		{
			{100, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{100, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 1, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{101, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{101, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{101, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{102, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
			//{100, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
		},
		
		/*�ڶ��ع����б�*/	
		{
			{101, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{101, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{101, 1, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{102, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{100, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
			//{100, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
		},
		
		/*�����ع����б�*/	
		{
			{101, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{101, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{101, 1, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{102, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{100, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
			//{100, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
		},
		
		/*���Ĺع����б�*/	
		{
			{101, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{101, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{101, 1, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{102, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{100, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
			//{100, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
		},
		
		/*����ع����б�*/	
		{
			{101, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{101, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{101, 1, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{102, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{100, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
			//{100, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
		},
		
		/*�����ع����б�*/	
		{
			{101, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{101, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{101, 1, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{102, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{100, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
			//{100, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
		},
		
		/*���߹ع����б�*/	
		{
			{101, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{101, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{101, 1, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{102, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{100, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
			//{100, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
		},
		
		/*�ڰ˹ع����б�*/	
		{
			{101, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{101, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{101, 1, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{102, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{100, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{100, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
			//{100, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
		},
	};
	
}
