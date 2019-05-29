package com.example.fivefivemm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.example.fivefivemm.service.Implements.SendSmsImplements;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendSmsTest {
	
	@Autowired
	public SendSmsImplements sendSmsImplements;

	@Test
	public void sendSmsTest() {
		SendSmsResponse response = sendSmsImplements.sendSmsForInform("15320225720", "12345");
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());
	}
}
