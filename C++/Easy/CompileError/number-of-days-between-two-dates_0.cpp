class Solution {
public:
    int daysBetweenDates(string date1, string date2) {
        
        int y1 = stoi(date1.substr(0, 4));
        int m1 = stoi(date1.substr(5, 2));
        int d1 = stoi(date1.substr(8, 2));
        int y2 = stoi(date2.substr(0, 4));
        int m2 = stoi(date2.substr(5, 2));
        int d2 = stoi(date2.substr(8, 2));
        int days1 = 0;
        int days2 = 0;
        for (int i = 1971; i < y1; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                days1 += 366;
            } else {
                days1 += 365;
            }
        }
        for (int i = 1971; i < y2; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                days2 += 366;
            } else {
                days2 += 365;
            }
        }
        int months1[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int months2[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((y1 % 4 == 0 && y1 % 100 != 0) || (y1 % 400 == 0)) {
            months1[2] = 29;
        }
        if ((y2 % 4 == 0 && y2 % 100 != 0) || (y2 % 400 == 0)) {
            months2[2] = 29;
        }
        for (int i = 1; i < m1; i++) {
            days1 += months1[i];
        }
        for (int i = 1; i < m2; i++) {
            days2 += months2[i];
        }
        days1 += d1;
        days2 += d2;
        return abs(days1
    }
};