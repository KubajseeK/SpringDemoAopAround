package sk.itsovy.kutka.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* sk.itsovy.kutka.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {

    }


    @Pointcut("execution(* sk.itsovy.kutka.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* sk.itsovy.kutka.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
