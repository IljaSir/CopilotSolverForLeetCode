class Solution {
public:
    int maxSumTwoNoOverlap(vector<int>& nums, int firstLen, int secondLen) {
        
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = firstLen; i <= n; ++i) {
            int first = sum[i] - sum[i - firstLen];
            for (int j = i + secondLen; j <= n; ++j) {
                int second = sum[j] - sum[j - secondLen];
                res = max(res, first + second);
            }
            for (int j = secondLen; j < i - firstLen; ++j) {
                int second = sum[j] - sum[j - secondLen];
                res = max(res, first + second);
            }
        }
        return res;
    }
};