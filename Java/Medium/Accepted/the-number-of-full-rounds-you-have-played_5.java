class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        
        int start = Integer.parseInt(loginTime.split(":")[0]) * 60 + Integer.parseInt(loginTime.split(":")[1]);
        int end = Integer.parseInt(logoutTime.split(":")[0]) * 60 + Integer.parseInt(logoutTime.split(":")[1]);
        if (end < start) {
            end += 24 * 60;
        }
        start = (start + 14) / 15 * 15;
        end = end / 15 * 15;
        return Math.max(0, end - start) / 15;
    }
}