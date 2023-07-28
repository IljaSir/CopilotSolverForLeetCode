class Solution {
public:
    string dayOfTheWeek(int day, int month, int year) {
        
        int days[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        int week[] = {4,0,1,4,6,2,4,0,3,5,1,3};
        int sum = 0;
        for (int i = 1971; i < year; i++) {
            sum += 365;
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                sum++;
            }
        }
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            days[1]++;
        }
        for (int i = 0; i < month - 1; i++) {
            sum += days[i];
        }
        sum += day - 1;
        string weekDay[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return weekDay[(sum + week[month - 1]) % 7];
    }
};