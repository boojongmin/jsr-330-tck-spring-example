package org.atinject.tck.auto.config;

import org.atinject.tck.auto.*;
import org.atinject.tck.auto.accessories.Cupholder;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    @Bean
    public Seatbelt seatbelt() {
        return new Seatbelt();
    }

    @Bean
    public FuelTank fuelTank() {
        return new FuelTank();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Drivers
    public DriversSeat driversSeat(Cupholder cupholder) {
        return new DriversSeat(cupholder);
    }

    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Primary
    public Seat seat(Cupholder cupholder) {
        return new Seat(cupholder);
    }
}
