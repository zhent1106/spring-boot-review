package com.soft1851.springboot.config;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootConfigApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootConfigApplication.class, args);
            new SpringApplicationBuilder(SpringbootConfigApplication.class)
                    .bannerMode(Banner.Mode.CONSOLE).run(args);
        }
    }

