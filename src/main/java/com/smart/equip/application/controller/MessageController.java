/**
 * 
 */
package com.smart.equip.application.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smart.equip.application.model.QuestionModel;
import com.smart.equip.application.service.SmartEquipMessagingService;

/**
 * @author Geetha
 *
 */
@RestController
@RequestMapping("/")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageController {
	
	@Autowired
	SmartEquipMessagingService aSmartService;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> randomNumberForQuestion() {
		 return aSmartService.questionsWithRandomNumber(); 
	}
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> answersForQuestion(@RequestBody QuestionModel questionModel) {
		 return aSmartService.checkAnswersForQuestion(questionModel); 
	}
}
