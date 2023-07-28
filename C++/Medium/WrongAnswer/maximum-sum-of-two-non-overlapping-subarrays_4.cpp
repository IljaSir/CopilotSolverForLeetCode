class Solution {
public:
    int maxSumTwoNoOverlap(vector<int>& nums, int firstLen, int secondLen) {
        
        int n = nums.size();
        vector<int> pre(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int l = pre[i + 1] - pre[i];
            if (i + firstLen > n) break;
            for (int j = i + firstLen; j < n; ++j) {
                int m = pre[j + 1] - pre[j];
                if (j + secondLen > n) break;
                int r = pre[j + secondLen] - pre[j];
                res = max(res, l + r);
            }
            for (int j = i + firstLen; j < n; ++j) {
                int m = pre[j + 1] - pre[j];
                if (j + firstLen > n) break;
                int r = pre[j + firstLen] - pre[j];
                res = max(res, l + r);
            }
        }
        return res;
    }
};