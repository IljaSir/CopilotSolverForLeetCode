class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        
        int login = Integer.parseInt(loginTime.substring(0, 2)) * 60 + Integer.parseInt(loginTime.substring(3, 5));
        int logout = Integer.parseInt(logoutTime.substring(0, 2)) * 60 + Integer.parseInt(logoutTime.substring(3, 5));
        if (logout < login) {
            logout += 24 * 60;
        }
        login = (login + 14) / 15 * 15;
        logout = logout / 15 * 15;
        return Math.max(0, logout - login) / 15;
    }
}