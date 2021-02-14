package sk.itsovy.kutka.aopdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.itsovy.kutka.aopdemo.Account;

import java.util.List;

@Aspect
@Component
@Order(2)

public class MyDemoLoggingAspect {

    @Around("execution(* sk.itsovy.kutka.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("Executing @Around on method" + method);

        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();
        long duration = end-begin;
        System.out.println("Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* sk.itsovy.kutka.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing @AfterFinally on method" + method);

    }

    @AfterThrowing(pointcut = "execution(* sk.itsovy.kutka.aopdemo.dao.AccountDAO.findAccounts(..))",throwing = "e")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable e) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing @AfterThrowing on method" + method);

        System.out.println("Exception: " + e);

    }

    @AfterReturning(
            pointcut = "execution(* sk.itsovy.kutka.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing AfterReturning on method: " + method);
        System.out.println("Result is: " + result);

        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account tempAccount : result) {
            String upperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(upperName);
        }
    }

//    @Before("execution(public void add*())")

    @Before("sk.itsovy.kutka.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("ASPECT @BEFORE");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println(methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object tempArgs : args) {
            System.out.println(tempArgs);

            if (tempArgs instanceof Account) {
                Account account = (Account) tempArgs;
                System.out.println("account name: " + account.getName());
            }
        }
    }


}
