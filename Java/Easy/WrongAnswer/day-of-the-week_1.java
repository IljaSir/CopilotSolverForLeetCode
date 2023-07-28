class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dayOfWeek = 4;
        for (int y = 1971; y < year; y++) {
            dayOfWeek += 365;
            if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
                dayOfWeek++;
            }
        }
        for (int m = 1; m < month; m++) {
            dayOfWeek += months[m - 1];
            if (m == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
                dayOfWeek++;
            }
        }
        dayOfWeek += day - 1;
        return days[dayOfWeek % 7];
    }
}