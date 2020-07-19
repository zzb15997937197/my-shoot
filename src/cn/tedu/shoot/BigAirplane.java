package cn.tedu.shoot;
import java.awt.image.BufferedImage;
/** ��л� */
public class BigAirplane extends FlyingObject implements Enemy {
	private static BufferedImage[] images;
	static{
		images = new BufferedImage[5];
		for(int i=0;i<images.length;i++){
			images[i] = loadImage("bigplane"+i+".png");
		}
	}
	
	private int step;
	
	public BigAirplane(){
		width = 66;
		height = 99;
		x = (int)(Math.random()*(World.WIDTH-this.width));
		y = -this.height;
		step = 4;
	}
	
	public void step(){
		y+=step;
	}
	
	int deadIndex = 1;
	public BufferedImage getImage(){
		if(isLife()){
			return images[0];
		}else if(isDead()){
			BufferedImage img = images[deadIndex++];
			if(deadIndex==images.length){
				state = REMOVE;
			}
			return img;
		}
		return null;
	}
	

	public int getScore(){
		return 3;
	}
	
	public boolean outOfBounds(){
		return this.y>=World.HEIGHT;
	}
}





