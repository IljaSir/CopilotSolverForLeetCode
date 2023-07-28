class Solution {
public:
    int countTime(string time) {
        
        int hh = (time[0] - '0') * 10 + (time[1] - '0');
        int mm = (time[3] - '0') * 10 + (time[4] - '0');
        if (hh < 0 || hh > 23) return 0;
        if (mm < 0 || mm > 59) return 0;
        return 1;
    }
    int numberOfValidClocks(string time) {
        int res = 0;
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                for (int k = 0; k < 10; ++k) {
                    for (int l = 0; l < 10; ++l) {
                        time[0] = '0' + i;
                        time[1] = '0' + j;
                        time[3] = '0' + k;
                        time[4] = '0' + l;
                        res += countTime(time);
                    }
                }
            }
        }
        return res;
    }
};