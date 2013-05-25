package com.zymr.client.main;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;

import com.zymr.client.bean.UserBean;
import com.zymr.client.service.UserGenraterService;


public class UserManagement {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int i=0;
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		context.start();
		
		MessageChannel channel = context.getBean("userchannel",MessageChannel.class);
		
		UserGenraterService userGenraterService=new UserGenraterService();
		
		Map <String,String> usermap = new TreeMap<String,String>();
		while(i<3)
		{
			usermap.put(userGenraterService.generateUser().get(i).getUsername(), userGenraterService.generateUser().get(i).getPassword());
						
			try
			{
				Thread.sleep(5000);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			i++;
			channel.send(MessageBuilder.withPayload(usermap).build());
		
			
		}
	

	}

}
