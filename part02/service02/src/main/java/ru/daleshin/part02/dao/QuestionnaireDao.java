package ru.daleshin.part02.dao;

import ru.daleshin.part02.model.Question;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

public interface QuestionnaireDao {

    void init(Resource resource) throws IOException;

    List<Question> getQuestionList();
}
