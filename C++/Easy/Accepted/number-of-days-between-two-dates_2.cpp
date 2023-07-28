class Solution {
public:
    int daysBetweenDates(string date1, string date2) {
        
        int year1 = stoi(date1.substr(0, 4));
        int month1 = stoi(date1.substr(5, 2));
        int day1 = stoi(date1.substr(8, 2));
        int year2 = stoi(date2.substr(0, 4));
        int month2 = stoi(date2.substr(5, 2));
        int day2 = stoi(date2.substr(8, 2));
        return abs(days(year1, month1, day1) - days(year2, month2, day2));
    }
    
    int days(int year, int month, int day) {
        int days = 0;
        for (int y = 1971; y < year; ++y) {
            days += 365;
            if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) {
                ++days;
            }
        }
        int months[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int m = 1; m < month; ++m) {
            days += months[m - 1];
            if (m == 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                ++days;
            }
        }
        days += day;
        return days;
    }
};