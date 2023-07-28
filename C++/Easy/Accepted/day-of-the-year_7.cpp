class Solution {
public:
    int dayOfYear(string date) {
        
        int year = stoi(date.substr(0, 4));
        int month = stoi(date.substr(5, 2));
        int day = stoi(date.substr(8, 2));
        int day_of_year = 0;
        for (int i = 1; i < month; ++i) {
            if (i == 2) {
                day_of_year += (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 29 : 28;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                day_of_year += 30;
            } else {
                day_of_year += 31;
            }
        }
        return day_of_year + day;
    }
};