package ru.daleshin.part02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import ru.daleshin.part02.dao.QuestionnaireDao;
import ru.daleshin.part02.dao.QuestionnaireDaoSimple;
import ru.daleshin.part02.service.QuestionnaireService;
import ru.daleshin.part02.service.QuestionnaireServiceImpl;

@Configuration
@PropertySource("classpath:application.properties")
public class AppProperties {
	
    @Bean
    public QuestionnaireService questionnaireService(QuestionnaireDao dao) {
        return new QuestionnaireServiceImpl(dao);
    }

    @Bean
    public QuestionnaireDao questionnaireDao() {
        return new QuestionnaireDaoSimple();
    }

}
