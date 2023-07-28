class Solution {
public:
    int countLargestGroup(int n) {
        
        vector<int> cnt(37, 0);
        for (int i = 1; i <= n; ++i) {
            int sum = 0;
            for (int j = i; j > 0; j /= 10) {
                sum += j % 10;
            }
            cnt[sum]++;
        }
        int maxCnt = 0;
        for (int i = 0; i < 37; ++i) {
            maxCnt = max(maxCnt, cnt[i]);
        }
        int res = 0;
        for (int i = 0; i < 37; ++i) {
            if (cnt[i] == maxCnt) {
                res++;
            }
        }
        return res;
    }
};