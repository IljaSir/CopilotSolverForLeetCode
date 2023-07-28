class Solution {
public:
    int maxSumTwoNoOverlap(vector<int>& nums, int firstLen, int secondLen) {
        
        int n = nums.size();
        vector<int> preSum(n+1, 0);
        for (int i = 0; i < n; ++i) {
            preSum[i+1] = preSum[i] + nums[i];
        }
        int res = 0;
        for (int i = firstLen; i <= n; ++i) {
            int sum1 = preSum[i] - preSum[i-firstLen];
            int sum2 = 0;
            for (int j = secondLen; j < i-firstLen+1; ++j) {
                sum2 = max(sum2, preSum[j] - preSum[j-secondLen]);
            }
            for (int j = i+secondLen; j <= n; ++j) {
                sum2 = max(sum2, preSum[j] - preSum[j-secondLen]);
            }
            res = max(res, sum1+sum2);
        }
        return res;
    }
};