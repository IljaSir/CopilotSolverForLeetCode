class Solution {
public:
    int numberOfRounds(string loginTime, string logoutTime) {
        
        int h1 = stoi(loginTime.substr(0,2));
        int m1 = stoi(loginTime.substr(3,2));
        int h2 = stoi(logoutTime.substr(0,2));
        int m2 = stoi(logoutTime.substr(3,2));
        int res = 0;
        if(h1 > h2 || (h1 == h2 && m1 > m2)) res += 24*4;
        res += (h2-h1)*4;
        res += m2/15 - m1/15;
        if(m1%15 != 0) res--;
        return max(0,res);
    }
};