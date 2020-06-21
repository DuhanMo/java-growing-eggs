package com.kh.breakegg.main.vo;

public class UserStatus {
	
	private int hungry = 50; //배고픔
	private int tiredness = 50; //피곤함
	private int growthRate =0;	//성장률
	
	public UserStatus() {
		super();
	}

	public UserStatus(int hungry, int tiredness, int growthRate) {
		super();
		this.hungry = hungry;
		this.tiredness = tiredness;
		this.growthRate = growthRate;
	}

	public int getHungry() {
		return hungry;
	}

	public void setHungry(int hungry) {
		this.hungry = hungry;
	}

	public int getTiredness() {
		return tiredness;
	}

	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	}

	public int getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(int growthRate) {
		this.growthRate = growthRate;
	}

	@Override
	public String toString() {
		return "유저 상태 \n 포만감 :" + hungry + "\n 피곤함 : " + tiredness + "\n 성장률" + growthRate;
	}
	

}
