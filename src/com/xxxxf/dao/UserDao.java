package com.xxxxf.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.xxxxf.pojo.User;

/**
*@author xxxxf 
*2018��7��10��
*/
@Repository
public interface UserDao {
	/**
	 * ��ѯ�û���Ϣ	
	 */
   public User getUser(@Param("userName") String userName,@Param("passWord") String passWord);
   /**
    * �����û�  
    */
   public int addUser(User user);
   /**
    * ��������ѯ�û�   
    */
   public String getUserByUserName(String userName);
}
