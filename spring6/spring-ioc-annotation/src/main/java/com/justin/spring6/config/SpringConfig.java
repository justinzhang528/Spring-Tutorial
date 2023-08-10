package com.justin.spring6.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //配置類（替代bean.xml配置文件）
@ComponentScan("com.justin.spring6")    //開啟組件掃描（才能對bean annotation生效）
public class SpringConfig {
}
