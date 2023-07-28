class Solution {
public:
    int daysBetweenDates(string date1, string date2) {
        
        auto days = [](string date) {
            int y = stoi(date.substr(0, 4));
            int m = stoi(date.substr(5, 2));
            int d = stoi(date.substr(8, 2));
            if (m < 3) {
                m += 12;
                y -= 1;
            }
            return 365 * y + y / 4 - y / 100 + y / 400 + (153 * m + 8) / 5 + d;
        };
        return abs(days(date1) - days(date2));
    }
};