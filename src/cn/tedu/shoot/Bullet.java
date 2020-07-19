package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** �ӵ� */
public class Bullet extends FlyingObject  {
	private static BufferedImage image;
	static{
		image = loadImage("bullet.png");
	}
	private int step;
	

	public Bullet(int x,int y){
		width = 8;
		height = 14;
		this.x = x;
		this.y = y;
		step = 4;
	}
	
	public void step(){
		y-=step;
	}
	
	public BufferedImage getImage(){
		if(isLife()){
			return image;
		}
		if(isDead()){
			state = REMOVE;
		}
		return null;
	}
	
	public boolean outOfBounds(){
		return this.y<=-this.height;
	}
}







