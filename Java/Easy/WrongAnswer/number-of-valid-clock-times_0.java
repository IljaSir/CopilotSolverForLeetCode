class Solution {
    public int countTime(String time) {
        
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            return 24 * 60;
        } else if (time.charAt(0) == '?') {
            if (time.charAt(1) <= '3') {
                return 20 * 60;
            } else {
                return 10 * 60;
            }
        } else if (time.charAt(1) == '?') {
            if (time.charAt(0) == '0' || time.charAt(0) == '1') {
                return 20 * 60;
            } else {
                return 10 * 60;
            }
        } else {
            if (time.charAt(0) == '2' && time.charAt(1) > '3') {
                return 0;
            } else {
                return 60;
            }
        }
    }

    public int countMinute(String time) {
        if (time.charAt(3) == '?' && time.charAt(4) == '?') {
            return 60;
        } else if (time.charAt(3) == '?') {
            return 10;
        } else if (time.charAt(4) == '?') {
            return 6;
        } else {
            return 1;
        }
    }
}