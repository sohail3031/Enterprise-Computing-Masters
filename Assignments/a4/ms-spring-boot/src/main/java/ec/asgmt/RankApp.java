package ec.asgmt;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//public class RankApp {
//    public static void main(String[] args) {
//        // Create an ApplicationContext container by reading in RankBeans.xml
//        @SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("RankBeans.xml");
//
//        // Get an instance of Rank with id 'rank-bean' from the container
//        Rank rankBean = (Rank) context.getBean("rank-bean");
//
//        // Use the Rank instance to get ranks and letter grades for the given scores
////        int[] scoresToCheck = {95, 85, 75, 65, 55}; // Example scores
////        int[] scoresToCheck = {71,71,85,70,85,99,70,79,89,83,96,85,82,84,96,77,89,81,71,90,89,71,99,99,84,74,90,75,73,86};
//        Integer[] scoresToCheck = rankBean.getScore();
//        
//        for (int score : scoresToCheck) {
//            String grade = rankBean.getGrade(score);
//            int rank = rankBean.getRank(score);
//        
//            System.out.println("Score: " + score + " - Rank: " + rank + " - Grade: " + grade);
//        }
//
//        // Predict the rank and grade of a given score
////        int scoreToPredict = 87; // Example score to predict
//        int scoreToPredict = 76; // Example score to predict
//        String predictedGrade = rankBean.getGrade(scoreToPredict);
//        int predictedRank = rankBean.getRank(scoreToPredict);
//        
//        System.out.println("Predicted Score: " + scoreToPredict + " - Rank: " + predictedRank + " - Grade: " + predictedGrade);
//    }
//}

@SpringBootApplication
public class RankApp {
	public static void main(String[] args) {
		SpringApplication.run(RankApp.class, args);
	}
}

//@RestController
//class ControllerGrade {
//	@RequestMapping("/grade/{number}")
//	String grade(@PathVariable String number, HttpServletResponse response) {
//		response.addHeader("Access-Control-Allow-Origin", "*");
//		response.addHeader("Access-Control-Allow-Methods", "GET, DELETE, HEAD, OPTIONS");
//		
//		return "{\"number\":\"" + number + "\"}";
//	}
//}
//
//@RestController
//class ContrllerRank {
//	@RequestMapping("/rank/{number}")
//	String rank(@PathVariable String number, HttpServletResponse response) {
//		response.addHeader("Access-Control-Allow-Origin", "*");
//		response.addHeader("Access-Control-Allow-Methods", "GET, DELETE, HEAD, OPTIONS");
//		
//		return "{\"number\":\"" + number + "\"}";
//	}
//}