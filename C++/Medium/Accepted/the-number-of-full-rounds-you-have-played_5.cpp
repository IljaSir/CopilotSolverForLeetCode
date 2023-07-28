class Solution {
public:
    int numberOfRounds(string loginTime, string logoutTime) {
        
        int l = stoi(loginTime.substr(0, 2)) * 60 + stoi(loginTime.substr(3, 2));
        int r = stoi(logoutTime.substr(0, 2)) * 60 + stoi(logoutTime.substr(3, 2));
        if (l > r) {
            r += 24 * 60;
        }
        l = (l + 14) / 15;
        r /= 15;
        return max(0, r - l);
    }
};