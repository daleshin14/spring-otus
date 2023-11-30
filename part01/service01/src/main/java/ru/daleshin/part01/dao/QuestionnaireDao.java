package ru.daleshin.part01.dao;

import ru.daleshin.part01.model.Question;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

public interface QuestionnaireDao {

    void init(Resource resource) throws IOException;

    List<Question> getQuestionList();
}
