class Solution {
public:
    int numberOfRounds(string loginTime, string logoutTime) {
        
        int loginHour = (loginTime[0] - '0') * 10 + (loginTime[1] - '0');
        int loginMin = (loginTime[3] - '0') * 10 + (loginTime[4] - '0');
        int logoutHour = (logoutTime[0] - '0') * 10 + (logoutTime[1] - '0');
        int logoutMin = (logoutTime[3] - '0') * 10 + (logoutTime[4] - '0');
        int login = loginHour * 60 + loginMin;
        int logout = logoutHour * 60 + logoutMin;
        if (logout < login) logout += 24 * 60;
        login = (login + 14) / 15 * 15;
        logout = logout / 15 * 15;
        return (logout - login) / 15;
    }
};