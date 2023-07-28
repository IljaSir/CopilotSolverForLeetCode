class Solution {
public:
    int lastStoneWeightII(vector<int>& stones) {
        
        int n = stones.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        vector<int> dp(target + 1);
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] * 2;
    }
};