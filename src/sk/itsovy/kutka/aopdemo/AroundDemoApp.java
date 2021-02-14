package sk.itsovy.kutka.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.kutka.aopdemo.dao.AccountDAO;
import sk.itsovy.kutka.aopdemo.service.TrafficFortuneService;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Main: AroundDemo");
        System.out.println("Calling GetFortune");

        String data = trafficFortuneService.getFortune();

        System.out.println("My fortune is: " + data);
        System.out.println("Finished");

        context.close();
    }
}
