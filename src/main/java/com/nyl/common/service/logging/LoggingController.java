package com.nyl.common.service.logging;

import org.springframework.web.bind.annotation.RestController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.savoirtech.logging.slf4j.json.logger.JsonLogger;
import com.savoirtech.logging.slf4j.json.logger.Logger;
import com.nyl.eis.common.service.domain.*;
import com.savoirtech.logging.slf4j.json.LoggerFactory;

import java.util.*;

@RestController
public class LoggingController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping("/testLogs")
    public String index() {
    	  LoggerFactory.setIncludeLoggerName(false);
          LoggerFactory.setDateFormatString("yyyy-MM-dd HH:mm:ss.SSS");

           com.savoirtech.logging.slf4j.json.logger.Logger LOGGER =  LoggerFactory.getLogger("JSONLogger");
    	 Map<String, String> optionalFields = new HashMap();
         optionalFields.put("ReferenceNumber", "NYL12345");
         LogExceptionObject logObj=new LogExceptionObject(); 
         LOGGER.error().message("APP CALCULATOR SERVICE LOG'")
         .field("applicationName", logObj.getApplicationName())
         .field("applicationHost", logObj.getApplicationHost())
         .field("resourceURI", logObj.getResourceURI())
         .field("resourceMethod",logObj.resourceMethod)
         .field("transactionId",logObj.getTransactionId())
         .field("messageId",logObj.getMessageId())
        .field("clientAppName",logObj.getClientAppName())
         
        .field("clientIPAddress", logObj.getClientIPAddress())
        .field("userAgent", logObj.getUserAgent())
        .field("subComponent", logObj.getSubComponent())
        .field("startTimestamp", logObj.getStartTimestamp())
        .field("threadName", logObj.getThreadName())
        .field("logType", logObj.getLogType())
        .field("priority",logObj.getPriority())
        .field("elapsed",logObj.getElapsed())
        .field("status",logObj.getStatus())
        .field("exceptionCode",logObj.getExceptionCode())
        .field("exceptionMessage",logObj.getExceptionMessage())
        .field("exceptionTarget",logObj.getExceptionTarget())
        .field("exceptionSeverity",logObj.getExceptionSeverity())
        .field("exceptionStack",logObj.getExceptionStack())
        .field("status",logObj.getStatus())
        .field("userAgent", logObj.getUserAgent())
        .map("subComponent", optionalFields).log() ;
         
        return "Greetings from Logging Frame work!";
    }
    
}
