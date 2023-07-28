class Solution {
    public int daysBetweenDates(String date1, String date2) {
        
        return Math.abs((int)(days(date1) - days(date2)));
    }
    
    public long days(String date) {
        String[] d = date.split("-");
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        int totalDays = 0;
        for (int i = 1971; i < year; i++) {
            if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }
        for (int i = 0; i < month - 1; i++) {
            if (i == 1 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                totalDays += 29;
            } else {
                totalDays += months[i];
            }
        }
        totalDays += day;
        return totalDays;
    }
}