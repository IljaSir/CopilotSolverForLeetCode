class Solution {
    public int daysBetweenDates(String date1, String date2) {
        
        return Math.abs( (int)(convert(date1) - convert(date2)) );
    }
    
    public long convert(String date) {
        long year = Integer.valueOf(date.substring(0, 4));
        long month = Integer.valueOf(date.substring(5, 7));
        long day = Integer.valueOf(date.substring(8, 10));
        long total = 0;
        for (long i = 1971; i < year; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                total += 366;
            } else {
                total += 365;
            }
        }
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            months[1] = 29;
        }
        for (int i = 0; i < month - 1; i++) {
            total += months[i];
        }
        total += day;
        return total;
    }
}