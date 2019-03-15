package com.aibaoxian.auth.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling // 启用定时任务
public class Task {
	
    @Scheduled(cron="${task.cron}")
	public void run(){
		System.out.println("Scheduled Running...");
	}
}
