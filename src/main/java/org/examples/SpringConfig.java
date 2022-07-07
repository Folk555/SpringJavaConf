package org.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.examples") //сканируем пакеты на компоненты(бины)
@PropertySource("properties.properties") //подключаем файл properties
public class SpringConfig {
    @Bean
    public Classic classic() {
        return new Classic();
    }
    @Bean
    public Rock rock() {
        return new Rock();
    }
    @Bean
    public Player player() {
        return new Player(classic());
    }
}
