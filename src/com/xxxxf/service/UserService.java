package com.xxxxf.service;

import com.xxxxf.pojo.User;

/**
*@author xxxxf 
*2018��7��10��
*/
public interface UserService {
	/**
	 * �û�ע��
	 */
   public void  regist(User user);
  /**
   * �û���¼ 
   */
   public void login(String userName,String passWord);
   /**
    * ����û��Ƿ����
    */
   public String checkUser(String userName);
}
