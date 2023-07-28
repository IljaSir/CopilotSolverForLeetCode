class Solution {
public:
    int countTime(string time) {
        
        int h = (time[0] - '0') * 10 + (time[1] - '0');
        int m = (time[3] - '0') * 10 + (time[4] - '0');
        if (h >= 0 && h <= 23 && m >= 0 && m <= 59) {
            return 1;
        }
        return 0;
    }
    int countValidTime(string time) {
        int count = 0;
        int h = (time[0] - '0') * 10 + (time[1] - '0');
        int m = (time[3] - '0') * 10 + (time[4] - '0');
        if (time[0] == '?' && time[1] == '?') {
            count += 24 * 60;
        } else if (time[0] == '?') {
            if (h >= 0 && h <= 9) {
                count += 60;
            } else if (h >= 10 && h <= 23) {
                count += 40;
            }
        } else if (time[1] == '?') {
            if (h >= 0 && h <= 1) {
                count += 60;
            } else if (h >= 20 && h <= 23) {
                count += 40;
            }
        }
        if (time[3] == '?' && time[4] == '?') {
            count += 24 * 60;
        } else if (time[3] == '?') {
            if (m >= 0 && m <= 9) {
                count += 10;
            } else if (m >= 10 && m <= 59) {
                count += 40;
            }
        } else if (time[4] == '?') {
            if (m >= 0 && m <= 5) {
                count += 10;
            } else if (m >= 6 && m <= 59) {
                count += 40;
            }
        }
        return count;
    }
};