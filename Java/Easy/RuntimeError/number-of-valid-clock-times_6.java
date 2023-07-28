class Solution {
    public int countTime(String time) {
        
        int count = 0;
        String[] timeArray = time.split(":");
        int hour = Integer.parseInt(timeArray[0]);
        int minute = Integer.parseInt(timeArray[1]);
        if (hour < 24 && minute < 60) {
            count++;
        }
        return count;
    }
    public int numberOfValidClockTimes(String time) {
        int count = 0;
        String[] timeArray = time.split(":");
        String hour = timeArray[0];
        String minute = timeArray[1];
        if (hour.charAt(0) == '?' && hour.charAt(1) == '?') {
            count += 4 * 6 * 10;
        } else if (hour.charAt(0) == '?') {
            int hourSecond = Integer.parseInt(hour.substring(1));
            int hourFirst = 0;
            if (hourSecond < 4) {
                hourFirst = 2;
            } else {
                hourFirst = 1;
            }
            count += 4 * 10;
        } else if (hour.charAt(1) == '?') {
            int hourFirst = Integer.parseInt(hour.substring(0, 1));
            int hourSecond = 0;
            if (hourFirst == 2) {
                hourSecond = 4;
            }
            count += 6 * 10;
        } else {
            count += countTime(hour + ":" + minute);
        }
        if (minute.charAt(0) == '?' && minute.charAt(1) == '?') {
            count += 6 * 10 * 6 * 10;
        } else if (minute.charAt(0) == '?') {
            int minuteSecond = Integer.parseInt(minute.substring(1));
            int minuteFirst = 0;
            if (minuteSecond < 6) {
                minuteFirst = 6;
            }
            count += 6 * 10;
        } else if (minute.charAt(1) == '?') {
            int minuteFirst = Integer.parseInt(minute.substring(0, 1));
            int minuteSecond = 0;
            if (minuteFirst == 6) {
                minuteSecond = 10;
            }
            count += 6 * 10;
        } else {
            count += countTime(hour + ":" + minute);
        }
        return count;
    }
}