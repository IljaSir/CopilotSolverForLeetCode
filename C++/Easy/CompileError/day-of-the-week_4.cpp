class Solution {
public:
    string dayOfTheWeek(int day, int month, int year) {
        
        int days = 0;
        for (int y = 1971; y < year; ++y) {
            days += isLeapYear(y) ? 366 : 365;
        }
        for (int m = 1; m < month; ++m) {
            days += daysOfMonth(m, isLeapYear(year));
        }
        days += day;
        return weekDays[days % 7];
    }
};