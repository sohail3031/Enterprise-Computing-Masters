package ec.asgmt;

import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.Comparator;

@Component
public class RankImpl implements Rank {
    private String name = "RankImpl";
    private Integer[] scores = {71,71,85,70,85,99,70,79,89,83,96,85,82,84,96,77,89,81,71,90,89,71,99,99,84,74,90,75,73,86};
    private int count = scores.length;
    private Grade grade; // Assume this is injected by Spring
    
    public RankImpl() {
        // Default constructor
    }

    // Constructor for Spring to inject the Grade bean
    public RankImpl(Grade grade) {
        this.grade = grade;
        
        sortArray();
    }

    @Override
    public String getGrade(int score) {
        return grade.getLetterGrade(score);
    }

    @Override
    public int getRank(int score) {
        // Perform a binary search to find the number of scores greater than 'score'
        int rank = 1;
        
        for (Integer s : scores) {
            if (s > score) {
                rank++;
            } else {
                break;
            }
        }
        
        return rank;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    
    public Integer[] getScore() {
    	sortArray();
    	
    	return scores;
    }
    
    public void sortArray() {
    	Arrays.sort(scores, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
    }
}
