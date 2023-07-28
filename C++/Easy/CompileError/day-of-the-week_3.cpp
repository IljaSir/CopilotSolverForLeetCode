class Solution {
public:
    string dayOfTheWeek(int day, int month, int year) {
        
        int days = 0;
        for (int i = 1971; i < year; ++i) {
            days += isLeapYear(i) ? 366 : 365;
        }
        for (int i = 1; i < month; ++i) {
            days += daysInMonth(i, year);
        }
        days += day - 1;
        return daysOfTheWeek[days % 7];
    }
};