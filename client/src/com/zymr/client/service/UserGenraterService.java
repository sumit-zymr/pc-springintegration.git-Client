package com.zymr.client.service;

import java.util.ArrayList;
import java.util.List;

import com.zymr.client.bean.UserBean;

public class UserGenraterService
{

	public List<UserBean> generateUser()
	{
		List<UserBean> userBeans=new ArrayList<UserBean>();
		UserBean u1=new UserBean("first", "first");
		userBeans.add(u1);
		UserBean u2=new UserBean("second", "second");
		userBeans.add(u2);
		UserBean u3=new UserBean("third", "third");
		userBeans.add(u3);
		return userBeans;
		
	}
}
