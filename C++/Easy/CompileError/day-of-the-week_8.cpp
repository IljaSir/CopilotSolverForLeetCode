class Solution {
public:
    string dayOfTheWeek(int day, int month, int year) {
        
        int days = 0;
        int y = 1971;
        while (y < year) {
            days += 365 + isLeap(y);
            y++;
        }
        for (int i = 1; i < month; i++) {
            days += monthDays[i];
        }
        days += day;
        if (month > 2 && isLeap(year)) days++;
        return weekday[days % 7];
    }
};