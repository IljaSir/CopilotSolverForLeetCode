class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        
        int loginHour = Integer.parseInt(loginTime.substring(0, 2));
        int loginMinute = Integer.parseInt(loginTime.substring(3));
        int logoutHour = Integer.parseInt(logoutTime.substring(0, 2));
        int logoutMinute = Integer.parseInt(logoutTime.substring(3));
        if (logoutHour < loginHour || (logoutHour == loginHour && logoutMinute < loginMinute)) {
            logoutHour += 24;
        }
        int loginRound = loginMinute / 15;
        if (loginRound * 15 < loginMinute) {
            loginRound++;
        }
        int logoutRound = logoutMinute / 15;
        int round = logoutHour * 4 + logoutRound - loginHour * 4 - loginRound;
        return round > 0 ? round : 0;
    }
}