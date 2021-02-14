package sk.itsovy.kutka.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.kutka.aopdemo.dao.AccountDAO;
import sk.itsovy.kutka.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account myAccount = new Account();
        myAccount.setName("Ubuntu");
        myAccount.setLevel("Diamond");
        accountDAO.addAccount(myAccount, true);
        accountDAO.doWork();

        accountDAO.setName("fool");
        accountDAO.setServiceCode("1337");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();


        membershipDAO.addDaco();
        membershipDAO.goToSleep();

        context.close();
    }
}
