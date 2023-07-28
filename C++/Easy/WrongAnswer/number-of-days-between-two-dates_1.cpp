class Solution {
public:
    int daysBetweenDates(string date1, string date2) {
        
        int y1 = stoi(date1.substr(0, 4));
        int m1 = stoi(date1.substr(5, 2));
        int d1 = stoi(date1.substr(8, 2));
        int y2 = stoi(date2.substr(0, 4));
        int m2 = stoi(date2.substr(5, 2));
        int d2 = stoi(date2.substr(8, 2));
        int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum1 = 0, sum2 = 0;
        for (int i = 1971; i < y1; i++) {
            sum1 += 365;
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) sum1++;
        }
        for (int i = 1; i < m1; i++) sum1 += days[i];
        if (y1 % 4 == 0 && y1 % 100 != 0 || y1 % 400 == 0) sum1++;
        sum1 += d1;
        for (int i = 1971; i < y2; i++) {
            sum2 += 365;
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) sum2++;
        }
        for (int i = 1; i < m2; i++) sum2 += days[i];
        if (y2 % 4 == 0 && y2 % 100 != 0 || y2 % 400 == 0) sum2++;
        sum2 += d2;
        return abs(sum1 - sum2);
    }
};