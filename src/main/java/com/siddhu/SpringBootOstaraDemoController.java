package com.siddhu;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootOstaraDemoController {
	
	Logger logger = LoggerFactory.getLogger(SpringBootOstaraDemoController.class);

    @GetMapping("/ostarametrics")
    public String getMetricDemo() {
//    	callMethod("INFO");
//    	callMethod("TRACE");
//    	callMethod("DEBUG");
//    	callMethod("ERROR");
//    	callMethod("WARN");
    	callLogMethod();
        return "Ostara Configured properly";
    }
    
    public String getLogInfo() {
    	
        logger.info("An INFO Message =========================");
       
        return "Ostara An INFO Message >>>>>>>>>>>>>>>>>>>>>";
    }
    
    public String getLogWarn() {
    	 logger.info("An WARN Message =========================");
         
         return "Ostara An WARN Message >>>>>>>>>>>>>>>>>>>>>";
    }
    
    public String getLogError() {
    	logger.info("An ERROR Message =========================");
        
        return "Ostara An ERROR Message >>>>>>>>>>>>>>>>>>>>>";
    }
    
    public String getLogDebug() {
    	logger.info("An DEBUG Message =========================");
        
        return "Ostara An DEBUG Message >>>>>>>>>>>>>>>>>>>>>";
    }
    
    public String getLogTrace() {
    	logger.info("An TRACE Message =========================");
        
        return "Ostara An TRACE Message >>>>>>>>>>>>>>>>>>>>>";
    }
    
    
    public void allLog()
    {
    	logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
    }
    public void callMethod(String logType)
    {
    	int delay = 0; // delay for x minutes
        int period = 5 * 1000; // repeat every x minutes

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                // put your task here
            	if(logType.equalsIgnoreCase("INFO"))
            	{
            		getLogInfo();
            	}
            	else if(logType.equalsIgnoreCase("TRACE"))
            	{
            		getLogTrace();
            	}
            	else if(logType.equalsIgnoreCase("DEBUG"))
            	{
            		getLogDebug();
            	}
            	else if(logType.equalsIgnoreCase("ERROR"))
            	{
            		getLogError();
            	}
            	else
            	{
            		getLogWarn();
            	}
                //System.out.println("Task "+ logType + " on " + new java.util.Date());
            }
        }, delay, period);
    }
    
    public void callLogMethod()
    {
    	int delay = 0; // delay for x minutes
        int period = 5 * 1000; // repeat every x minutes

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                // put your task here
            	allLog();
                //System.out.println("Task "+ logType + " on " + new java.util.Date());
            }
        }, delay, period);
    }
}
