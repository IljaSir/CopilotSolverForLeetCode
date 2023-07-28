class Solution {
public:
    int countTime(string time) {
        
        int count = 0;
        for (int i = 0; i < time.size(); i++) {
            if (time[i] == '?') {
                if (i == 0) {
                    if (time[1] == '?' || time[1] < '4') {
                        count += 2;
                    } else {
                        count += 1;
                    }
                } else if (i == 1) {
                    if (time[0] == '?' || time[0] < '2') {
                        count += 4;
                    } else {
                        count += 3;
                    }
                } else if (i == 3) {
                    count += 5;
                } else if (i == 4) {
                    count += 9;
                }
            }
        }
        return count;
    }
    int numberOfValidClockTimes(string time) {
        int count = countTime(time);
        for (int i = 0; i < time.size(); i++) {
            if (time[i] == '?') {
                if (i == 0) {
                    if (time[1] == '?' || time[1] < '4') {
                        count += countTime(time.substr(0, i) + "1" + time.substr(i + 1));
                        count += countTime(time.substr(0, i) + "2" + time.substr(i + 1));
                    } else {
                        count += countTime(time.substr(0, i) + "1" + time.substr(i + 1));
                    }
                } else if (i == 1) {
                    if (time[0] == '?' || time[0] < '2') {
                        count += countTime(time.substr(0, i) + "3" + time.substr(i + 1));
                        count += countTime(time.substr(0, i) + "4" + time.substr(i + 1));
                        count += countTime(time.substr(0, i) + "5" + time.substr(i + 1));
                        count += countTime(time.substr(0, i) + "6" + time.substr(i + 1));
                    } else {
                        count += countTime(time.substr(0, i) + "3" + time.substr(i + 1));
                        count += countTime(time.substr(0, i) + "4" + time.substr(i
    }
};