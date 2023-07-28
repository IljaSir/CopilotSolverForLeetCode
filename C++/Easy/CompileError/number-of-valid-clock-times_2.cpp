class Solution {
public:
    int countTime(string time) {
        
        int h = (time[0] - '0') * 10 + (time[1] - '0');
        int m = (time[3] - '0') * 10 + (time[4] - '0');
        return h * 60 + m;
    }
    int countDigitOne(int n) {
        int res = 0;
        for (long long i = 1; i <= n; i *= 10) {
            long long divider = i * 10;
            res += (n / divider) * i + min(max(n % divider - i + 1, 0LL), i);
        }
        return res;
    }
    int numberOfValidClockTimes(string time) {
        int res = 0;
        int cur = countTime(time);
        int h = (time[0] - '0') * 10 + (time[1] - '0');
        int m = (time[3] - '0') * 10 + (time[4] - '0');
        if (time[0] == '?') {
            if (time[1] == '?') {
                res += 24 * 60;
            } else {
                if (h <= 23) {
                    res += 60;
                }
                if (h <= 2) {
                    res += 60;
                }
            }
        } else {
            if (time[1] == '?') {
                if (h <= 23) {
                    res += 10;
                }
                if (h <= 2) {
                    res += 10;
                }
            } else {
                if (h <= 23) {
                    res += 1;
                }
                if (h <= 2) {
                    res += 1;
                }
            }
        }
        if (time[3] == '?') {
            if (time[4] == '?') {
                res += 60;
            } else {
                if (m <= 59) {
                    res += 1;
                }
            }
        } else {
            if (time[4] == '?') {
                if (m <= 59) {
                    res += 1;
                }
            } else {
                if (m <= 59) {
                    res += 1;
                }
            }
        }
        int h1 = (time
    }
};