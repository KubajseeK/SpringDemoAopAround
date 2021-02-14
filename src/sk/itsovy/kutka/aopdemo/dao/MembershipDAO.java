package sk.itsovy.kutka.aopdemo.dao;


import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addDaco() {
        System.out.println(getClass() + " DOING STUFF");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + ": Sleeping already");
    }
}
