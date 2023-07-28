class Solution {
public:
    int numberOfRounds(string loginTime, string logoutTime) {
        
        int h1 = stoi(loginTime.substr(0, 2));
        int m1 = stoi(loginTime.substr(3, 2));
        int h2 = stoi(logoutTime.substr(0, 2));
        int m2 = stoi(logoutTime.substr(3, 2));
        int t1 = h1 * 60 + m1;
        int t2 = h2 * 60 + m2;
        if (t1 > t2) t2 += 24 * 60;
        int res = 0;
        for (int i = t1 + 15 - (t1 % 15); i <= t2; i += 15) {
            if (i % 60 == 0) {
                ++res;
            }
        }
        return res;
    }
};