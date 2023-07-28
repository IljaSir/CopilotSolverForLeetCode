class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        
        int n = weights.size();
        vector<long long> preSum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + weights[i];
        }
        vector<vector<long long>> dp(n + 1, vector<long long>(k + 1, 0));
        for (int i = 0; i <= n; i++) {
            dp[i][1] = preSum[i];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                long long minVal = INT_MAX;
                for (int p = 0; p < i; p++) {
                    minVal = min(minVal, max(dp[p][j - 1], preSum[i] - preSum[p]));
                }
                dp[i][j] = minVal;
            }
        }
        return dp[n][k];
    }
    int minimumIncompatibility(vector<int>& nums, int k) {
        int n = nums.size();
        if (n % k != 0) {
            return -1;
        }
        int m = n / k;
        map<int, int> cnt;
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] > k) {
                return -1;
            }
        }
        sort(nums.begin(), nums.end());
        vector<int> weights;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                weights.push_back(nums[i]);
            }
        }
        return putMarbles(weights, k) - putMarbles(weights, 1);
    }
};