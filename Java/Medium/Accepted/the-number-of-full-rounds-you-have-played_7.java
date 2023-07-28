class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        
        int loginHour = Integer.parseInt(loginTime.substring(0,2));
        int loginMin = Integer.parseInt(loginTime.substring(3,5));
        int logoutHour = Integer.parseInt(logoutTime.substring(0,2));
        int logoutMin = Integer.parseInt(logoutTime.substring(3,5));
        int loginMinutes = loginHour * 60 + loginMin;
        int logoutMinutes = logoutHour * 60 + logoutMin;
        if (logoutMinutes < loginMinutes) {
            logoutMinutes += 24 * 60;
        }
        loginMinutes = (loginMinutes + 14) / 15 * 15;
        logoutMinutes = logoutMinutes / 15 * 15;
        return Math.max(0, logoutMinutes - loginMinutes) / 15;
    }
}