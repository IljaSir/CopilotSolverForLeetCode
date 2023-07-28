class Solution {
public:
    int minNumberOfFrogs(string croakOfFrogs) {
        
        int n = croakOfFrogs.size();
        if (n % 5) return -1;
        int cnt[5] = {0};
        int res = 0;
        for (char c : croakOfFrogs) {
            if (c == 'c') {
                if (cnt[0] < cnt[1]) return -1;
                ++cnt[0];
            } else if (c == 'r') {
                if (cnt[1] < cnt[2]) return -1;
                ++cnt[1];
            } else if (c == 'o') {
                if (cnt[2] < cnt[3]) return -1;
                ++cnt[2];
            } else if (c == 'a') {
                if (cnt[3] < cnt[4]) return -1;
                ++cnt[3];
            } else if (c == 'k') {
                if (cnt[4] < cnt[0]) return -1;
                ++cnt[4];
            }
            res = max(res, cnt[0] - cnt[4]);
        }
        return res;
    }
};