package com.ops.demo.ucenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author a1517
 * @since 2024-01-07 22:10:12
 */
@SpringBootApplication(scanBasePackages = "com.ops.demo")
public class UcenterWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(UcenterWebApplication.class, args);
    }

}
