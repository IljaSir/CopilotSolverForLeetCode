class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        
        const int MOD = 1000000007;
        int n = nums.size();
        vector<int> preSum(n, 0);
        preSum[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            preSum[i] = preSum[i-1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n-2; ++i) {
            int l = i+1, r = n-1;
            int leftSum = preSum[i];
            while (l < r) {
                int m = l + (r-l)/2;
                int midSum = preSum[m] - preSum[i];
                int rightSum = preSum[n-1] - preSum[m];
                if (leftSum <= midSum && midSum <= rightSum) {
                    l = m+1;
                } else if (leftSum > midSum) {
                    l = m+1;
                } else {
                    r = m;
                }
            }
            int m = l;
            int midSum = preSum[m] - preSum[i];
            int rightSum = preSum[n-1] - preSum[m];
            if (leftSum <= midSum && midSum <= rightSum) {
                ans = (ans + (m-i)) % MOD;
            }
        }
        return ans;
    }
};