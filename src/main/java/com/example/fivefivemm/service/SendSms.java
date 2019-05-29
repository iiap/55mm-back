package com.example.fivefivemm.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

public interface SendSms {
	/**
	 * 发送通知短信
	 * 
	 * @param phoneNum  电话号码
	 * @throws ClientException 
	 */
	SendSmsResponse sendSmsForInform(String phoneNum, String code);

}
