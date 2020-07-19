package cn.tedu.shoot;

public interface Award {
	//小蜜蜂实现Award接口，获得奖励类型有两种不同的情况，一种奖励双倍火力
	//一种奖励生命值
	public int DOUBLE_FIRE = 0;
	public int LIFE = 1;
	public int getType();
}
