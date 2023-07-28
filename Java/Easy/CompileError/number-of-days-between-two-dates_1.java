class Solution {
    public int daysBetweenDates(String date1, String date2) {
        
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] daysLeap = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] date1s = date1.split("-");
        String[] date2s = date2.split("-");
        int year1 = Integer.parseInt(date1s[0]);
        int month1 = Integer.parseInt(date1s[1]);
        int day1 = Integer.parseInt(date1s[2]);
        int year2 = Integer.parseInt(date2s[0]);
        int month2 = Integer.parseInt(date2s[1]);
        int day2 = Integer.parseInt(date2s[2]);
        int year = Math.abs(year1 - year2);
        int month = Math.abs(month1 - month2);
        int day = Math.abs(day1 - day2);
        int days1 = 0;
        int days2 = 0;
        if (year1 > year2) {
            for (int i = 0; i < year; i++) {
                if (isLeapYear(year2 + i)) {
                    days1 += 366;
                } else {
                    days1 += 365;
                }
            }
            for (int i = 0; i < month1; i++) {
                if (isLeapYear(year1)) {
                    days1 -= daysLeap[i];
                } else {
                    days1 -= days[i];
                }
            }
            days1 -= day1;
            for (int i = 0; i < month2; i++) {
                if (isLeapYear(year2)) {
                    days1 += daysLeap[i];
                } else {
                    days1 += days[i];
                }
            }
            days1 += day2;
        } else if (year2 > year1) {
            for (int i = 0; i < year; i++) {
                if (isLeapYear(year1 + i)) {
                    days2 += 366;
                } else {
                    days2 += 365;
                }
            }
            for (int i = 0; i < month2; i++) {
                if (isLeapYear(year2)) {
                    days2 -= daysLeap[i];
                } else {
                    days2 -= days[i];
                }
            }
    }
}