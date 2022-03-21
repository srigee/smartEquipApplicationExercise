/**
 * 
 */
package com.smart.equip.application.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smart.equip.application.model.QuestionModel;

/**
 * @author Geetha
 *
 */
@Service
public class SmartEquipMessagingService {
	
	public ResponseEntity<Map<String, Object>> questionsWithRandomNumber() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		Random random = new Random();
		int x =0;
		x = random.nextInt(11); 
		if(x>9) {
			requestMap.put("question", "Please sum the numbers " + x + "," + random.nextInt(10));
		}else {
			requestMap.put("question", "Please sum the numbers "+ x + ","  + random.nextInt(10) + "," + random.nextInt(10));
		}
		requestMap.put("answer", "");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "MessageController");
		return ResponseEntity.accepted().headers(headers).body(requestMap);
	}
	
 	public ResponseEntity<Map<String, Object>> checkAnswersForQuestion(QuestionModel questionModel) {		 
		Map<String, Object> requestMap = new HashMap<String, Object>();
		String aQ = questionModel.getQuestion();
		int sumQueNum =0;
		for(int i=0; i<aQ.length(); i++) {
			char aQchar = aQ.charAt(i);
			if(Character.isDigit(aQchar)) {
				sumQueNum = sumQueNum + Character.getNumericValue(aQchar);
			}
		}
		if(sumQueNum == Integer.valueOf(questionModel.getAnswer())){
			requestMap.put("status of your answer",HttpStatus.OK);
		}else {
			requestMap.put("status of your answer",HttpStatus.BAD_REQUEST);
		}
		
	    HttpHeaders headers = new HttpHeaders(); 
	    headers.add("Responded","MessageController"); 
	    return ResponseEntity.accepted().headers(headers).body(requestMap);
 	}
}
