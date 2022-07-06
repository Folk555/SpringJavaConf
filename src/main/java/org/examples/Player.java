package org.examples;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("player")
@PropertySource("application.properties") //подключаем файл properties
//@Scope("prototype") //Будет создаваться новый бин
// при каждом запросе из контекста. singelton - ссылка на  единый существующий бин
public class Player {
    private IGenre genre;
    @Value("${player.name}") //инициализация переменной значением из файла
    private String name;
    @Value("${player.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Player() {}

    //IoC Inversion of Control. Внедряем зависимость IGenre
    @Autowired //Аннотация автоматически внедряет зависсимость
            //@Qualifier("rock") решает проблему когда имеется несколько подходящих
            // бинов. Мы явно указываем какой бин внедрять
    Player(@Qualifier("rock") IGenre iGenre){
        this.genre = iGenre;
    };

    public void play(){
        genre.playGenre();
    }

    //Обязательное наличие метода для задания поля IGenre при создании бина через XML
    public void setGenre(IGenre genre) {
        this.genre = genre;
    }

    /***
     * @PostConstruct и @PreDestroy работают для singelton по 1 разу
     * В случае prototype работает только @PostConstruct для каждого бина. @PreDestroy не работает.
     */
    @PostConstruct
    public void doInit(){
        System.out.println("Init");
    }

    @PreDestroy
    public void doDestroy(){
        System.out.println("Dest");
    }

}
