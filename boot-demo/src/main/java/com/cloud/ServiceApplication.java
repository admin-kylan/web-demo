package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * className Application
 * by Kylan
 *
 * @author Kylan
 * @date 2019-04-14 17:36
 */
@SpringBootApplication
@Configuration
@EntityScan(value = "com.cloud.entity")
@EnableJpaRepositories(value = {"com.cloud.repository"})
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);


    }


}
