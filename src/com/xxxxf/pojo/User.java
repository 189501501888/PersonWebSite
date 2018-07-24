package com.xxxxf.pojo;

import java.io.Serializable;

/**
*@author xxxxf 
*2018��7��10��
*/
public class User implements Serializable{
	
	private static final long serialVersionUID = 89448952;
	private String userName;
	private String passWord;
	/**
	 * getter && setter����	
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	/**
	 * toString����	
	 */
	@Override
	public String toString() {
		return "user [userName=" + userName + ", passWord=" + passWord + "]";
	}
	
	
	
}
