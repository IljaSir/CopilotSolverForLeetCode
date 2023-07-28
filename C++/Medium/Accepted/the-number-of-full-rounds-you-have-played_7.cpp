class Solution {
public:
    int numberOfRounds(string loginTime, string logoutTime) {
        
        int t1 = stoi(loginTime.substr(0, 2)) * 60 + stoi(loginTime.substr(3, 2));
        int t2 = stoi(logoutTime.substr(0, 2)) * 60 + stoi(logoutTime.substr(3, 2));
        if (t1 > t2) t2 += 24 * 60;
        t1 = (t1 + 14) / 15 * 15;
        t2 = t2 / 15 * 15;
        return max(0, t2 - t1) / 15;
    }
};