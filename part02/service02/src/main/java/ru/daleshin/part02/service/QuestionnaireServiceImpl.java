package ru.daleshin.part02.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import ru.daleshin.part02.dao.QuestionnaireDao;
import ru.daleshin.part02.model.Question;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {
	
    private final QuestionnaireDao dao;

    @Value("${settings.answersToPassCount:5}")
    private int answersToPassCount;
    @Value("${settings.filePath}")
    private Resource resource;
    
    private final Scanner sc = new Scanner(System.in);

    @SneakyThrows
    public void run() {
        System.out.print("Please enter your name: ");
        String userName = sc.nextLine();
        System.out.print("Please enter your surname: ");
        String userSurname = sc.nextLine();
        System.out.printf("Welcome %s %s!\n", userName, userSurname);
        System.out.println("Please answer 5 questions.");

        dao.init(resource);
        runQuestionnaire();
    }
    
    @SneakyThrows
    private Integer runQuestionnaire() {
    	List<Question> listQuestions = dao.getQuestionList();
        int questionNumber = 1;
        int rightAnswersCount = 0;
        String userAnswer;
        for (Question question : listQuestions) {
            System.out.printf("%d. %s \nEnter your answer: ", questionNumber, question.getQuestionWording());
            userAnswer = sc.nextLine();
            if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
            	rightAnswersCount++;
            }
            questionNumber++;
        }
        System.out.printf("Your result is %d/%d right answers.\n", rightAnswersCount, listQuestions.size());
        processResults(rightAnswersCount);
        return rightAnswersCount;
    }

    private void processResults(Integer rightAnswersCount){
        if (rightAnswersCount >= answersToPassCount) {
            System.out.println("You passed!");
        } else {
            boolean isOkYesNotAnswer = false;
            String userAnswer = null;
            while (Boolean.FALSE.equals(isOkYesNotAnswer)){
                System.out.print("You failed. Try again? Enter \"y\" for \"yes\" or \"n\" for \"no\": ");
                userAnswer = sc.nextLine();
                if (List.of("y", "n").contains(userAnswer))
                	isOkYesNotAnswer = true;
            }
            if (userAnswer.equals("y")) {
            	runQuestionnaire();
            }
        }
    }

}
