package ru.daleshin.part02;

import ru.daleshin.part02.service.QuestionnaireService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainApp.class);

        QuestionnaireService questionnaire = context.getBean(QuestionnaireService.class);
        questionnaire.run();
    }
    
}