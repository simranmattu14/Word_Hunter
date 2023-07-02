public class Stats {

    // Player name
    private String playerName;

    // Points earned in total for that round
    private int highestPointsEarned;

    // Words guessed per round
    private int wordsGuessed;

    /**
     * Stars earned. At the end of each round. Points are transferred into
     * stars.
     */
    private int stars;

    public Stats(String playerName) {
        this.playerName = playerName;
        this.highestPointsEarned = 0;
        this.wordsGuessed = 0;
        this.stars = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getHighestPointsEarned() {
        return highestPointsEarned;
    }

    public int getWordsGuessed() {
        return wordsGuessed;
    }

    public int getStars() {
        return stars;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setHighestPointsEarned(int highestPointsEarned) {
        this.highestPointsEarned = highestPointsEarned;
    }

    public void setWordsGuessed(int wordsGuessed) {
        this.wordsGuessed = wordsGuessed;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
