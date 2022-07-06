package org.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        //получение контектса по аннотациям
        ApplicationContext contextAnnotation = new AnnotationConfigApplicationContext("org.examples");

        //Получение контекста по XML
        //ApplicationContext context2 = new ClassPathXmlApplicationContext("appContext.xml");

        Player pl = (Player) contextAnnotation.getBean("player");
        //Classic classic = contextAnnotation.getBean("classic", Classic.class);
        //pl.setGenre(classic);
        pl.setVolume(11);
        System.out.println(pl.getVolume());
        System.out.println(pl.getName());
        pl.play();

        Player pl2 = (Player) contextAnnotation.getBean("player");
        System.out.println(pl2.getVolume());


        ((ConfigurableApplicationContext)contextAnnotation).close();
    }
}
