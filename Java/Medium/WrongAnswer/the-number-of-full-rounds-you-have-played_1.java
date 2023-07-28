class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        
        int loginHour = Integer.parseInt(loginTime.substring(0, 2));
        int loginMinute = Integer.parseInt(loginTime.substring(3, 5));
        int logoutHour = Integer.parseInt(logoutTime.substring(0, 2));
        int logoutMinute = Integer.parseInt(logoutTime.substring(3, 5));
        int loginRound = loginHour * 4 + loginMinute / 15;
        int logoutRound = logoutHour * 4 + logoutMinute / 15;
        if (logoutRound < loginRound) {
            logoutRound += 96;
        }
        return Math.max(0, logoutRound - loginRound);
    }
}