class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        
        int start = Integer.parseInt(loginTime.substring(0, 2)) * 60 + Integer.parseInt(loginTime.substring(3));
        int end = Integer.parseInt(logoutTime.substring(0, 2)) * 60 + Integer.parseInt(logoutTime.substring(3));
        if (end < start) end += 24 * 60;
        start = (start + 14) / 15 * 15;
        end = end / 15 * 15;
        return Math.max(0, end - start) / 15;
    }
}