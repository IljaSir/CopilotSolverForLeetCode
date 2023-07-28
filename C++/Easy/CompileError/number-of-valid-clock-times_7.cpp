class Solution {
public:
    int countTime(string time) {
        
        int h = (time[0]-'0')*10 + (time[1]-'0');
        int m = (time[3]-'0')*10 + (time[4]-'0');
        if (h>=24 || m>=60) return 0;
        return 1;
    }
    int countValidTime(string time) {
        if (time[0]=='?' && time[1]=='?') {
            time[0]='2';
            time[1]='3';
        } else if (time[0]=='?') {
            if (time[1] > '3') {
                time[0]='1';
            } else {
                time[0]='2';
            }
        } else if (time[1]=='?') {
            if (time[0]=='2') {
                time[1]='3';
            } else {
                time[1]='9';
            }
        }
        if (time[3]=='?') {
            time[3]='5';
        }
        if (time[4]=='?') {
            time[4]='9';
        }
        return countTime(time);
    }
    int countValidTime2(string time) {
        if (time[0]=='?') {
            if (time[1]=='?' || time[1] <= '3') {
                time[0]='2';
            } else {
                time[0]='1';
            }
        }
        if (time[1]=='?') {
            if (time[0]=='2') {
                time[1]='3';
            } else {
                time[1]='9';
            }
        }
        if (time[3]=='?') {
            time[3]='5';
        }
        if (time[4]=='?') {
            time[4]='9';
        }
        return countTime(time);
    }
    int countValidTime3(string time) {
        if (time[0]=='?') {
            time[0]='2';
        }
        if (time[1]=='?') {
            if (time[0]=='2') {
                time[1]='3';
            } else {
                time[1]='9';
            }
        }
        if (time[3]=='?') {
            time[3]='5';
        }
        if (time[4]=='?') {
            time[4]='9';
        }
        return countTime(time
    }
};