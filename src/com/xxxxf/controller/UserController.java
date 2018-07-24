package com.xxxxf.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.java.swing.plaf.windows.resources.windows;
import com.xxxxf.dao.UserDao;
import com.xxxxf.pojo.User;
import com.xxxxf.service.UserService;

/**
*@author xxxxf 
*2018��7��10��
*/
@Controller
public class UserController {
	//����ע��
	@Autowired
	private UserService userService=null;
	/**
	 * ע�Ṧ��ʵ��
	 * */
	@RequestMapping(value="/register.do")
	@ResponseBody
	public ModelAndView regist(User user,Model model,HttpServletResponse response) throws IOException {
		System.out.println("#################################################");
		System.out.println("�û�ע��:"+"�˺�:"+user.getUserName()+" "+"����:"+user.getPassWord());
		String userName=user.getUserName();
		String result=userService.checkUser(userName);
			if (result==null) {
			userService.regist(user);
			response.setContentType("text/html;charset=utf-8");
		    PrintWriter out = response.getWriter();
		    out.print("<script language=\"javascript\">alert('ע��ɹ���ǰ����¼ҳ��');window.location.href='/PersonWebSite/login.jsp'</script>");
			//model.addAttribute("msg","ע��ɹ�");
			//return new ModelAndView("redirect:/login.jsp");
			}else {
				response.setContentType("text/html;charset=utf-8");
			    PrintWriter out = response.getWriter();
			    out.print("<script language=\"javascript\">alert('ע��ʧ��!�˺��Ѵ���!');window.location.href='/PersonWebSite/register.jsp'</script>");
				//model.addAttribute("msg","�˺Ŵ���,������ע��");
				//return new ModelAndView("redirect:/register.jsp");     
			}
			return null;
			
	}
	/**
	 * ��¼����ʵ��
	 * */
	@RequestMapping(value="/login.do")
	@ResponseBody
	public  ModelAndView login( @RequestBody User user,HttpServletRequest request,HttpServletResponse response) {
		/*Model model,HttpServletRequest request,HttpServletResponse response*/
		System.out.println("***********************************");
		String username=user.getUserName();
		//request.getParameter(username);
		String password=user.getPassWord();
		System.out.println("�û���¼:"+"�˺�:"+username+" "+"����:"+password);
		String result=userService.login(username, password);
		System.out.println("�����ݲ�ѯ���:"+result);
		/*response.getWriter().write(username);*/
		if (result != null) {
			try {
				response.getWriter().write("true");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				response.getWriter().write("false");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//model.addAttribute("msg", "��½�ɹ�");
		return null;
		
	}
}
