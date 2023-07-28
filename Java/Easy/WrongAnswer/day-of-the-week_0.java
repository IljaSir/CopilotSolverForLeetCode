class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int daysFrom1971 = 0;
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                daysFrom1971 += 366;
            } else {
                daysFrom1971 += 365;
            }
        }
        for (int i = 1; i < month; i++) {
            if (i == 2 && isLeapYear(year)) {
                daysFrom1971 += 29;
            } else {
                daysFrom1971 += months[i];
            }
        }
        daysFrom1971 += day;
        return days[(daysFrom1971 - 1) % 7];
    }
    private boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        if (year % 400 == 0) {
            return true;
        }
        return false;
    }
}