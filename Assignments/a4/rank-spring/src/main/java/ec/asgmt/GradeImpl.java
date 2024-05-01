package ec.asgmt;

import org.springframework.stereotype.Component;

@Component
public class GradeImpl implements Grade {
    private String name;
    private int[] gradeBoundary = { 100, 90, 85, 80, 77, 73, 70, 0 };
    private String[] letterGrade = { "A+", "A", "A-", "B+", "B", "B-", "F" };
    private int count = 8;
	
    public String getLetterGrade(int numericalGrade) {
        // Binary search for the appropriate letter grade
        int low = 0;
        int high = count - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (numericalGrade >= gradeBoundary[mid]) {
                high = mid - 1;
            	
                if (numericalGrade >= 90) {
                  return "A+";
              } else if (numericalGrade >= 85 && numericalGrade < 90) {
                  return "A";
              } else if (numericalGrade >= 80 && numericalGrade < 85) {
                  return "A-";
              } else if (numericalGrade >= 77 && numericalGrade < 80) {
                  return "B+";
              } else if (numericalGrade >= 73 && numericalGrade < 77) {
                  return "B";
              } else if (numericalGrade >= 70 && numericalGrade < 73) {
                  return "B-";
              } else {
                  return "F";
              }
            } else {
                low = mid + 1;
            }
        }

        return "Invalid grade";
    }
    
    public void updateGradeBoundaryAndLetterGrade(int[] newGradeBoundary, String[] newLetterGrade) {
        this.gradeBoundary = newGradeBoundary;
        this.letterGrade = newLetterGrade;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
