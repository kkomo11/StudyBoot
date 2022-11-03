package com.iu.home.schedule;

import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestSchedule {
	
//	@Scheduled(fixedRate = 3000, initialDelayString = "1000")
	public void ts1() {
		log.info("스케줄 실행");
	}
	
//	@Scheduled(cron = "* * * * * *")
	public void cron() {
		log.info("Cron 매초 실행");
		log.info(Calendar.getInstance().getTime().toString());
	}

}
