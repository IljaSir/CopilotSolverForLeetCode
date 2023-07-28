class Solution {
    public int countTime(String time) {
        
        if (time.equals("??:??")) {
            return 1440;
        }
        if (time.startsWith("?")) {
            if (time.charAt(1) > '3' && time.charAt(1) != '?') {
                return 10;
            }
            return 20;
        }
        if (time.startsWith("2")) {
            if (time.charAt(1) == '?') {
                return 4;
            }
            if (time.charAt(1) > '3') {
                return 0;
            }
            return 4;
        }
        if (time.startsWith("1") || time.startsWith("0")) {
            if (time.charAt(1) == '?') {
                return 10;
            }
            return 10;
        }
        return 0;
    }
    public int countMinute(String time) {
        if (time.endsWith("??")) {
            return 60;
        }
        if (time.endsWith("?")) {
            return 10;
        }
        if (time.endsWith("0") || time.endsWith("5")) {
            return 1;
        }
        return 0;
    }
    public int countSecond(String time) {
        if (time.endsWith("??")) {
            return 60;
        }
        if (time.endsWith("?")) {
            return 10;
        }
        return 1;
    }
}