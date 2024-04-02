public enum Moves {
    Group("ROCK", "PAPER", "SCISSORS");
    private final String rock;
    private final String paper;
    private final String scissors;

    Moves(String rock, String paper, String scissors){
        this.rock = rock;
        this.paper = paper;
        this.scissors = scissors;
    }

    public String getRock() {
        return rock;
    }

    public String getPaper() {
        return paper;
    }

    public String getScissors() {
        return scissors;
    }
}
