class Solution {
    public int convertTime(String current, String correct) {
        
        int ans = 0;
        int c = Integer.parseInt(current.substring(0,2)) * 60 + Integer.parseInt(current.substring(3,5));
        int d = Integer.parseInt(correct.substring(0,2)) * 60 + Integer.parseInt(correct.substring(3,5));
        int diff = d - c;
        if(diff >= 60) {
            ans += diff / 60;
            diff %= 60;
        }
        if(diff >= 15) {
            ans += diff / 15;
            diff %= 15;
        }
        if(diff >= 5) {
            ans += diff / 5;
            diff %= 5;
        }
        ans += diff;
        return ans;
    }
    public int numberOfRounds(String startTime, String finishTime) {
        int ans = 0;
        int c = Integer.parseInt(startTime.substring(0,2)) * 60 + Integer.parseInt(startTime.substring(3,5));
        int d = Integer.parseInt(finishTime.substring(0,2)) * 60 + Integer.parseInt(finishTime.substring(3,5));
        if(c > d) {
            d += 24 * 60;
        }
        int diff = d - c;
        if(diff >= 60) {
            ans += diff / 60;
            diff %= 60;
        }
        if(diff >= 15) {
            ans += diff / 15;
            diff %= 15;
        }
        if(diff >= 5) {
            ans += diff / 5;
            diff %= 5;
        }
        ans += diff;
        return ans;
    }
    public int numberOfRounds1(String startTime, String finishTime) {
        int ans = 0;
        int c = convertTime(startTime, "00:00");
        int d = convertTime(finishTime, "00:00");
        if(c > d) {
            d += 24 * 60;
        }
        int diff = d - c;
        if(diff >= 60) {
            ans += diff / 60;
            diff %= 60;
        }
        if(diff >= 15) {
            ans += diff / 15;
            diff %= 15;
        }
        if(diff >= 5) {
            ans += diff / 5;
            diff %= 5;
        }
        ans += diff;
        return ans;
    }
}