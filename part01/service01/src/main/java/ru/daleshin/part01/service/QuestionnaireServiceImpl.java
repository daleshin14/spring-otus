package ru.daleshin.part01.service;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import ru.daleshin.part01.dao.QuestionnaireDaoSimple;
import ru.daleshin.part01.model.Question;
import org.springframework.core.io.Resource;

import java.util.List;

@AllArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final QuestionnaireDaoSimple dao;
    private final Resource resource;

    @SneakyThrows
    public void printQuestions() {
        dao.init(resource);
        List<Question> questionList = dao.getQuestionList();

        System.out.println("Please answer the questions:");
        for (Question item : questionList) {
            System.out.println(item.getQuestionWording() + " (answer: " + item.getAnswer()+")");
        }
    }
}
