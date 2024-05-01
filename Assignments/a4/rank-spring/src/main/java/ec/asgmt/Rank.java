package ec.asgmt;

public interface Rank {
    // Simply returns the letter grade for the given score
    public String getGrade(int score);

    // Returns the rank of the given score
    public int getRank(int score);
    
    public Integer[] getScore();
}
