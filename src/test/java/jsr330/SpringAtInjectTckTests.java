package jsr330;

import junit.framework.Test;
import org.atinject.tck.Tck;
import org.atinject.tck.auto.Car;
import org.atinject.tck.auto.Convertible;
import org.atinject.tck.auto.Drivers;
import org.atinject.tck.auto.DriversSeat;
import org.atinject.tck.auto.FuelTank;
import org.atinject.tck.auto.Seat;
import org.atinject.tck.auto.Tire;
import org.atinject.tck.auto.V8Engine;
import org.atinject.tck.auto.accessories.Cupholder;
import org.atinject.tck.auto.accessories.SpareTire;

import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Jsr330ScopeMetadataResolver;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.GenericApplicationContext;

public class SpringAtInjectTckTests {

    // 참고 https://github.com/spring-projects/spring-framework/blob/deecab63114699abfe43e55489300ce0515d2188/spring-context/src/test/java/org/springframework/context/annotation/jsr330/SpringAtInjectTckTests.java


//    <dependency>
//        <groupId>javax.inject</groupId>
//        <artifactId>javax.inject-tck</artifactId>
//        <version>1</version>
//        <scope>test</scope>
//    </dependency>
    @SuppressWarnings("unchecked")
    public static Test suite() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        AnnotatedBeanDefinitionReader bdr = new AnnotatedBeanDefinitionReader(ac);
        bdr.setScopeMetadataResolver(new Jsr330ScopeMetadataResolver());

        ac.scan("org.atinject.tck.auto");

        ac.refresh();
        Car car = ac.getBean(Car.class);

        return Tck.testsFor(car, false, true);
    }

}
