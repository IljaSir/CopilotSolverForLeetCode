class Solution {
public:
    string dayOfTheWeek(int day, int month, int year) {
        
        vector<string> week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        vector<int> days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int daysCount = 0;
        for (int i = 1971; i < year; ++i) {
            daysCount += 365;
            if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
                ++daysCount;
            }
        }
        for (int i = 0; i < month - 1; ++i) {
            daysCount += days[i];
            if (i == 1 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                ++daysCount;
            }
        }
        daysCount += day - 1;
        return week[daysCount % 7];
    }
};