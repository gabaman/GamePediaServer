package com.stan.gamepedia.spring.config;


import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.stan.gamepedia.spring.config.MybatisConfig;

@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.stan.gamepedia.mapper");
        return mapperScannerConfigurer;
    }

}
