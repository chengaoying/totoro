package totoro;

import java.io.IOException;

import javax.microedition.lcdui.Image;

/**
 * ͼƬ��Դ��������Ϣ��
 * @author Administrator
 *
 */
public class Resource implements Common {
	
	
	private static short NUMS = 0;
	
	public static String[] imagesrcs = {};
	
	private static final Image[] images = new Image[NUMS];

	public static Image loadImage(int id){
		if(images[id]==null){
			try {
				images[id] = Image.createImage(imagesrcs[id]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return images[id];
	}
	
	/*�ͷ�ͼƬ*/
	public static void freeImage(int id){
		images[id] = null;
	}
}
