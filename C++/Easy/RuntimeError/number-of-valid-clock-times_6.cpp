class Solution {
public:
    int countTime(string time) {
        
        int h = stoi(time.substr(0, 2));
        int m = stoi(time.substr(3, 2));
        if (h >= 0 && h <= 23 && m >= 0 && m <= 59) {
            return 1;
        }
        return 0;
    }
    int countValidTime(string time) {
        int count = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                string h = to_string(i);
                if (h.length() == 1) {
                    h = "0" + h;
                }
                string m = to_string(j);
                if (m.length() == 1) {
                    m = "0" + m;
                }
                if (time[0] == '?' || time[0] == h[0]) {
                    if (time[1] == '?' || time[1] == h[1]) {
                        if (time[3] == '?' || time[3] == m[0]) {
                            if (time[4] == '?' || time[4] == m[1]) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    int numberOfValidClockTimes(string time) {
        int count = 0;
        for (int i = 0; i < time.length(); i++) {
            if (time[i] == '?') {
                time[i] = '0';
                count += countTime(time);
                time[i] = '1';
                count += countTime(time);
                time[i] = '2';
                count += countTime(time);
                time[i] = '3';
                count += countTime(time);
                time[i] = '4';
                count += countTime(time);
                time[i] = '5';
                count += countTime(time);
                time[i] = '6';
                count += countTime(time);
                time[i] = '7';
                count += countTime(time);
                time[i] = '8';
                count += countTime(time);
                time[i] = '9';
                count += countTime(time);
                time[i] = '?';
            }
        }
        return count;
    }
};