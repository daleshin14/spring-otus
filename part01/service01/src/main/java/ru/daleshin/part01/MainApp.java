package ru.daleshin.part01;

import ru.daleshin.part01.service.QuestionnaireService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
    	try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");) {
    		QuestionnaireService questionnaire = context.getBean(QuestionnaireService.class);
    		questionnaire.printQuestions();
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
}