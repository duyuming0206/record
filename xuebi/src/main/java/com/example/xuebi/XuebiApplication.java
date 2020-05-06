package com.example.xuebi;

import com.example.xuebi.util.MyRunable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class XuebiApplication {

	public static void main(String[] args) {
		//save();
		SpringApplication.run(XuebiApplication.class, args);
	}

	//系统启动第二天0点执行判断是否为月底保存操作，并每天重复执行
//	public static void save(){
//		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
//		int delay = 24-hour;
//		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//		scheduledExecutorService.scheduleAtFixedRate(new MyRunable(), delay, 24, TimeUnit.HOURS);
//	}

}
