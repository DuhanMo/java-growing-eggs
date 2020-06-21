package com.kh.breakegg.main.vo;

public class User {

	private String id; //유저 아이디
	private static int growUp = 0;
	private static int tiredness = 50;
	private static int hungry = 50;
	

	public User() {}
	
	public User(String id) {
		super();
		this.id = id;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public int getGrowUp() {
		return growUp;
	}
	public void setGrowUp(int growUp) {
		this.growUp = growUp;
	}
	public int getTiredness() {
		return tiredness;
	}
	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	}
	public int getHungry() {
		return hungry;
	}
	public void setHungry(int hungry) {
		this.hungry = hungry;
	}
	
		
}
