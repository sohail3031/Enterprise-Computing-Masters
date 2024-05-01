package ec.asgmt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GradeApp {
    public static void main(String[] args) {
        // Create an ApplicationContext by reading in GradeBeans.xml
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("GradeBeans.xml");

        // Get an instance of Grade of id 'grade-bean' from the container
        Grade gradeBean = (Grade) context.getBean("grade-bean");

        // Use the Grade instance to get the letter grades for percentage grades from 66 to 100
        for (int i = 66; i <= 100; i++) {
            System.out.print(i + ":" + gradeBean.getLetterGrade(i) + " ");
        }
        
        System.out.println();

//        // Get a new Grade instance from the container
//        Grade newGradeBean = (Grade) context.getBean("grade-bean");
//
//        // Reset properties gradeBoundary and letterGrade
//        newGradeBean.setGradeBoundary(new int[]{100, 90, 85, 80, 77, 73, 70, 67, 63, 60, 57, 53, 50, 0});
//        newGradeBean.setLetterGrade(new String[]{"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"});

     // Get a new Grade instance from the container
        Grade newGradeBean = (Grade) context.getBean("grade-bean");

        // Update properties gradeBoundary and letterGrade
        newGradeBean.updateGradeBoundaryAndLetterGrade(
            new int[]{100, 90, 85, 80, 77, 73, 70, 67, 63, 60, 57, 53, 50, 0},
            new String[]{"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"}
        );
        
        // Use the new Grade instance to get the letter grades for percentage grades from 46 to 100
        for (int i = 46; i <= 100; i++) {
            System.out.print(i + ":" + newGradeBean.getLetterGrade(i) + " ");
        }
        
        System.out.println();
    }
}
