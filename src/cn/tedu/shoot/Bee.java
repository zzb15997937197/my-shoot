package cn.tedu.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Bee extends FlyingObject implements Award {
	private static BufferedImage[] images;
	static{
		images = new BufferedImage[5];
		for(int i=0;i<images.length;i++){
			images[i] = loadImage("bee"+i+".png");
		}
	}
	
	private int xStep; //小蜜蜂x轴移动速度
	private int yStep; //小蜜蜂y轴移动速度
	private int awardType; //奖励类型
	
	
	public Bee(){
		Random rand=new Random();
		width = 60;
		height = 50;
		x = (int)(Math.random()*(World.WIDTH-this.width));
		y = -this.height;
		xStep = 3;
		yStep = 4;
		awardType = (int)(Math.random()*2);
		int a=rand.nextInt(2);
		if(a==0){
			xStep=-xStep;
		}
	}
	
	/*
	 * 
      小蜜蜂移动
	 */
	public void step(){
		x+=xStep;
		y+=yStep;
		if(x>=World.WIDTH-this.width || x<=0){
			xStep*=-1;
		}
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
	
	public int getType(){
		return awardType;
	}
	
	public boolean outOfBounds(){
		return this.y>=World.HEIGHT;
	}
}










