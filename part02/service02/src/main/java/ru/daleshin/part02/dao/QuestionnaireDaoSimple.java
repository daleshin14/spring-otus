package ru.daleshin.part02.dao;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import ru.daleshin.part02.model.Question;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionnaireDaoSimple implements QuestionnaireDao {
	
    private List<Question> questionList = new ArrayList<>();

    public void init(Resource resource) throws IOException {
        InputStream is = resource.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(br);

        for (CSVRecord row : parser) {
            String questionVal = row.get("question").trim();
            String answerVal = row.get("answer").trim();

            Question question = new Question(questionVal, answerVal);
            questionList.add(question);
        }

    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}
