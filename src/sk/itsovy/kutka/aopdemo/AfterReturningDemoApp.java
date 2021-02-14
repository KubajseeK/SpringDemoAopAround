package sk.itsovy.kutka.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.kutka.aopdemo.dao.AccountDAO;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = accountDAO.findAccounts(false);

        System.out.println("Main Program: After Returning Demo App");
        System.out.println("------");

        System.out.println(accounts);

        context.close();
    }
}
