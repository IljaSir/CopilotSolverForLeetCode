class Solution {
public:
    int countTime(string time) {
        
        int count = 0;
        if (time[0] == '?' && time[1] == '?') {
            count += 24 * 60;
        } else if (time[0] == '?') {
            count += ((time[1] - '0') < 4 ? 24 : 16) * 60;
        } else if (time[1] == '?') {
            count += (time[0] == '2' ? 4 : 10) * 60;
        } else {
            count += 60;
        }
        if (time[3] == '?' && time[4] == '?') {
            count += 24 * 60;
        } else if (time[3] == '?') {
            count += 6 * 10;
        } else if (time[4] == '?') {
            count += 10;
        }
        return count;
    }
    int numberOfValidClockTimes(string time) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (time[i] == '?') {
                for (int j = 0; j < 10; j++) {
                    time[i] = j + '0';
                    count += countTime(time);
                }
                time[i] = '?';
                break;
            }
        }
        return count;
    }
};