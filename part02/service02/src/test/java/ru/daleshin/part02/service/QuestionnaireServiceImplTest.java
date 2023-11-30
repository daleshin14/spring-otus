package ru.daleshin.part02.service;

import ru.daleshin.part02.dao.QuestionnaireDaoSimple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class QuestionnaireServiceImplTest {
	
    @Mock
    private QuestionnaireDaoSimple dao;
    @InjectMocks
    private QuestionnaireServiceImpl questionnaireService;

    @Test
    void notNullTest() {
        assertNotNull(questionnaireService);
    }

    @Test
    void printQuestionsTest() {
        questionnaireService.run();

        Mockito.verify(dao).getQuestionList();// times(1) is the default and can be omitted 
    }
}
