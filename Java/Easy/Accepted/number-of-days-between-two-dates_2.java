class Solution {
    public int daysBetweenDates(String date1, String date2) {
        
        return Math.abs(days(date1) - days(date2));
    }
    public int days(String date) {
        String[] ymd = date.split("-");
        int year = Integer.parseInt(ymd[0]);
        int month = Integer.parseInt(ymd[1]);
        int day = Integer.parseInt(ymd[2]);
        int days = day;
        for (int i = 1971; i < year; i++) {
            days += isLeap(i) ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            days += daysOfMonth(i, year);
        }
        return days;
    }
    public boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
    public int daysOfMonth(int month, int year) {
        if (month == 2) {
            return isLeap(year) ? 29 : 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 31;
    }
}