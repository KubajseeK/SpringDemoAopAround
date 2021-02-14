package sk.itsovy.kutka.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.kutka.aopdemo.dao.AccountDAO;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;

        try {
            boolean tripWire = false;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("After throwing exception caught." + e);
        }

        System.out.println("Main Program: After Throwing Demo App");
        System.out.println("------");

        System.out.println(accounts);

        context.close();
    }
}
