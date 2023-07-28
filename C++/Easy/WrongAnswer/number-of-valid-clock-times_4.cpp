class Solution {
public:
    int countTime(string time) {
        
        int hour = (time[0] - '0') * 10 + time[1] - '0';
        int minute = (time[3] - '0') * 10 + time[4] - '0';
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            return 0;
        }
        return 1;
    }
    int numberOfValidClockTimes(string time) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            time[0] = i + '0';
            for (int j = 0; j < 10; j++) {
                time[1] = j + '0';
                for (int k = 0; k < 6; k++) {
                    time[3] = k + '0';
                    for (int l = 0; l < 10; l++) {
                        time[4] = l + '0';
                        count += countTime(time);
                    }
                }
            }
        }
        return count;
    }
};