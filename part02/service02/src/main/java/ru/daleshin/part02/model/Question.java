package ru.daleshin.part02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Question {
	
    private final String questionWording;
    
    private final String answer;
    
}
