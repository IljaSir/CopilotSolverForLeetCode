class Solution {
public:
    string dayOfTheWeek(int day, int month, int year) {
        
        vector<string> day_of_week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        vector<int> days_of_month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            days_of_month[1] = 29;
        }
        int days = 0;
        for (int i = 1971; i < year; i++) {
            days += 365;
            if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
                days++;
            }
        }
        for (int i = 0; i < month - 1; i++) {
            days += days_of_month[i];
        }
        days += day - 1;
        return day_of_week[days % 7];
    }
};