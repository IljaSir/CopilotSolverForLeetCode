class Solution {
public:
    int dayOfYear(string date) {
        
        int year = stoi(date.substr(0, 4));
        int month = stoi(date.substr(5, 2));
        int day = stoi(date.substr(8, 2));
        int days = day;
        for (int i = 1; i < month; i++) {
            if (i == 2) {
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                    days += 29;
                else
                    days += 28;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                days += 30;
            } else {
                days += 31;
            }
        }
        return days;
    }
};