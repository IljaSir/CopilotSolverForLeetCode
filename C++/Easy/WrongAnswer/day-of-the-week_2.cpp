class Solution {
public:
    string dayOfTheWeek(int day, int month, int year) {
        
        vector<string> week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        vector<int> month_day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        for (int i = 1971; i < year; i++) {
            days += 365;
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                days++;
            }
        }
        for (int i = 0; i < month - 1; i++) {
            days += month_day[i];
        }
        if (month > 2 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
            days++;
        }
        days += day;
        return week[days % 7];
    }
};