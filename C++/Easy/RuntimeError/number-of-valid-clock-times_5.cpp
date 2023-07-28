class Solution {
public:
    int countTime(string time) {
        
        int h = stoi(time.substr(0, 2));
        int m = stoi(time.substr(3, 2));
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            return 0;
        }
        return 1;
    }
    
    int countValidTime(string time) {
        int cnt = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                string h = (i < 10) ? "0" + to_string(i) : to_string(i);
                string m = (j < 10) ? "0" + to_string(j) : to_string(j);
                string tmp = h + ":" + m;
                if (tmp[0] == time[0] || time[0] == '?') {
                    if (tmp[1] == time[1] || time[1] == '?') {
                        if (tmp[3] == time[3] || time[3] == '?') {
                            if (tmp[4] == time[4] || time[4] == '?') {
                                cnt++;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
};