class Solution {
public:
    int numberOfRounds(string loginTime, string logoutTime) {
        
        int h1 = stoi(loginTime.substr(0, 2));
        int m1 = stoi(loginTime.substr(3, 2));
        int h2 = stoi(logoutTime.substr(0, 2));
        int m2 = stoi(logoutTime.substr(3, 2));
        if(h1 > h2 || (h1 == h2 && m1 > m2)){
            h2 += 24;
        }
        if(m1 % 15 != 0){
            m1 = m1 - m1 % 15 + 15;
        }
        if(m2 % 15 != 0){
            m2 = m2 - m2 % 15;
        }
        return (h2 - h1) * 4 + (m2 - m1) / 15;
    }
};