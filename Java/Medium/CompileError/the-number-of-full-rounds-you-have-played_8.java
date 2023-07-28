class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        
        int[] login = parseTime(loginTime);
        int[] logout = parseTime(logoutTime);
        int startRound = roundNum(login[0], login[1]);
        int endRound = roundNum(logout[0], logout[1]);
        if (startRound > endRound) {
            endRound += 96;
        }
        return Math.max(0, endRound - startRound);
    }

    private int roundNum(int hour, int min) {
        int round = hour * 4 + min / 15;
        if (min % 15 != 0) {
            round++;
        }
        return round;
    }
}