package ec.asgmt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class RankController {

   @Autowired
   private Grade gradeService;

   @Autowired
   private Rank rankService;

   @RequestMapping("/grade/{score}")
   public String getGrade(@PathVariable int score) {
       return "Grade: " + gradeService.getLetterGrade(score);
   }

   @RequestMapping("/rank/{score}")
   public String getRank(@PathVariable int score) {
       return "Rank: " + rankService.getRank(score);
   }

   @RequestMapping("/grade-rank/{score}")
   public String getGradeAndRank(@PathVariable int score) {
       return "Grade: " + gradeService.getLetterGrade(score) + " - Rank: " + getRank(score);
   }
}

// @Controller
// public class RankController {
// 	@Autowired
//   private Grade gradeService;

//   @Autowired
//   private Rank rankService;

//   @RequestMapping("/grade/{score}")
//   public String getGrade(@RequestParam(name = "grade", required = false, defaultValue = "76") int score) {
//       return "Grade: " + gradeService.getLetterGrade(score);
//   }

//   @RequestMapping("/rank/{score}")
//   public String getRank(@RequestParam(name = "rank", required = false, defaultValue = "76") int score) {
//       return "Rank: " + rankService.getRank(score);
//   }

//   @RequestMapping("/grade-rank/{score}")
//   public String getGradeAndRank(@RequestParam(name = "rank", required = false, defaultValue = "76") int score) {
//       return "Grade: " + gradeService.getLetterGrade(score) + " - Rank: " + getRank(score);
//   }
// }
