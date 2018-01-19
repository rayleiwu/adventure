package com.adventure.howto.spring;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.spark.launcher.SparkLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/***
 * 
 * https://spring.io/guides/gs/scheduling-tasks/
 * 
 */
@Component
public class ScheduledTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedDelay = 5000) // You can also use @Scheduled(cron=". . .")
    public void reportCurrentTime() throws IOException, InterruptedException {
        System.out.println("The time is now " + dateFormat.format(new Date()));
        
        Process spark = new SparkLauncher()
        	.setAppResource("/home/hduser/git/sbd/dist/scala.jar")
        	.setMainClass("com.busyentry.scala.sandbox.SparkApp")
            .setMaster("spark://RaysUnix:7077")  //spark://RaysUnix:7077 local
            .setAppName("WordCount")
            .setConf("spark.eventLog.enabled", "true")
            .setConf("spark.eventLog.dir", "/tmp/spark-events")
            .launch();
        
        spark.waitFor();
     
    }
}