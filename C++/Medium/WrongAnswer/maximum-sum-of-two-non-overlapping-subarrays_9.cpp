class Solution {
public:
    int maxSumTwoNoOverlap(vector<int>& nums, int firstLen, int secondLen) {
        
        int n = nums.size(), sum = 0;
        vector<int> prefix(n+1, 0);
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            if (i + firstLen - 1 < n) {
                cur += prefix[i+firstLen] - prefix[i];
                if (i + firstLen + secondLen - 1 < n) {
                    cur += prefix[i+firstLen+secondLen] - prefix[i+firstLen];
                    res = max(res, cur);
                }
                if (i - secondLen >= 0) {
                    cur += prefix[i] - prefix[i-secondLen];
                    res = max(res, cur);
                }
            }
            if (i + secondLen - 1 < n) {
                cur += prefix[i+secondLen] - prefix[i];
                if (i + secondLen + firstLen - 1 < n) {
                    cur += prefix[i+secondLen+firstLen] - prefix[i+secondLen];
                    res = max(res, cur);
                }
                if (i - firstLen >= 0) {
                    cur += prefix[i] - prefix[i-firstLen];
                    res = max(res, cur);
                }
            }
        }
        return res;
    }
};