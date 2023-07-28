class Solution {
    public int countTime(String time) {
        
        int count = 0;
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        if (hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59) {
            count++;
        }
        return count;
    }
    public int numberOfValidClockTimes(String time) {
        int count = 0;
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            count += 24 * 60;
        } else if (time.charAt(0) == '?') {
            count += 24 * 60;
            int temp = Integer.parseInt(time.substring(1, 2));
            if (temp >= 0 && temp <= 3) {
                count -= 4 * 60;
            } else {
                count -= 4 * 60;
                count += 2 * 60;
            }
        } else if (time.charAt(1) == '?') {
            count += 24 * 60;
            int temp = Integer.parseInt(time.substring(0, 1));
            if (temp == 2) {
                count -= 4 * 60;
            }
        } else {
            count += countTime(time);
        }
        if (time.charAt(3) == '?' && time.charAt(4) == '?') {
            count += 24 * 60;
        } else if (time.charAt(3) == '?') {
            count += 24 * 60;
            count -= 6 * 10;
        } else if (time.charAt(4) == '?') {
            count += 24 * 60;
            count -= 6 * 10;
        } else {
            count += countTime(time);
        }
        return count;
    }
}