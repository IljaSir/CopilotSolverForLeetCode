class Solution {
public:
    int countTime(string time) {
        
        int hh = (time[0] - '0') * 10 + (time[1] - '0');
        int mm = (time[3] - '0') * 10 + (time[4] - '0');
        return hh * 60 + mm;
    }
    int numberOfValidClockTimes(string time) {
        int hh = (time[0] - '0') * 10 + (time[1] - '0');
        int mm = (time[3] - '0') * 10 + (time[4] - '0');
        int hhMax = 23;
        int mmMax = 59;
        int hhMin = 0;
        int mmMin = 0;
        if (time[0] == '?') {
            if (time[1] == '?') {
                hhMax = 23;
            } else {
                if (time[1] <= '3') {
                    hhMax = 19;
                } else {
                    hhMax = 9;
                }
            }
        } else {
            if (time[1] == '?') {
                if (time[0] <= '1') {
                    hhMax = 19;
                } else {
                    hhMax = 9;
                }
            }
        }
        if (time[3] == '?') {
            if (time[4] == '?') {
                mmMax = 59;
            } else {
                mmMax = 50 + time[4] - '0';
            }
        } else {
            if (time[4] == '?') {
                mmMax = 50 + time[3] - '0';
            }
        }
        if (time[0] == '?') {
            if (time[1] == '?') {
                hhMin = 0;
            } else {
                if (time[1] <= '3') {
                    hhMin = 0;
                } else {
                    hhMin = 10;
                }
            }
        } else {
            if (time[1] == '?') {
                if (time[0] <= '1') {
                    hhMin = 0;
                } else {
                    hhMin = 10;
                }
            }
        }
        if (time[3] == '?') {
            if (time[4] == '?') {
    }
};