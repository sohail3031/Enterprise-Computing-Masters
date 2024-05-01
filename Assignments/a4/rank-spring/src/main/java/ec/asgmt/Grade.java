package ec.asgmt;

public interface Grade {
    public String getLetterGrade(int numericalGrade);
    
    public void updateGradeBoundaryAndLetterGrade(int[] newGradeBoundary, String[] newLetterGrade);
}