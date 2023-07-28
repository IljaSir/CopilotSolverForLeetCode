class Solution {
public:
    int numberOfRounds(string loginTime, string logoutTime) {
        
        int hour1 = stoi(loginTime.substr(0, 2));
        int min1 = stoi(loginTime.substr(3, 2));
        int hour2 = stoi(logoutTime.substr(0, 2));
        int min2 = stoi(logoutTime.substr(3, 2));
        if (hour1 > hour2 || (hour1 == hour2 && min1 > min2)) {
            hour2 += 24;
        }
        if (min1 % 15 != 0) {
            min1 = (min1 / 15 + 1) * 15;
        }
        if (min2 % 15 != 0) {
            min2 = min2 / 15 * 15;
        }
        return (hour2 - hour1) * 4 + (min2 - min1) / 15;
    }
};