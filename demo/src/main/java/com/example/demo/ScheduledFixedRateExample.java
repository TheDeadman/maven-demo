package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;

@EnableAsync
@Component
public class ScheduledFixedRateExample {

  @Autowired
  private RestRequestor restRequestor;

  private static String time = "Not Set";

  @PostConstruct
  public void onStartup() {
    scheduleFixedRateTaskAsync();
  }

  @EventListener(ScheduledFixedRateExample.class)
  public void onSchedule() {
    System.out.println("\nSCHEDULED\n");
    scheduleFixedRateTaskAsync();
  }

  @Async
  @Scheduled(cron = "0/5 * * * * *")
  public void scheduleFixedRateTaskAsync() {
    String tempTime = restRequestor.requestNewTime();
    System.out.println(
        "Fixed rate task async - " + tempTime);
    time = tempTime;

  }

  public String getTime() {
    return time;
  }

}