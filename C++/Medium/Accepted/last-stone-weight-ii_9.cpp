class Solution {
public:
    int lastStoneWeightII(vector<int>& stones) {
        
        int n = stones.size();
        int sum = 0;
        for (auto& s : stones) sum += s;
        vector<int> dp(sum / 2 + 1, 0);
        for (int i = 0; i < n; i++) {
            for (int j = sum / 2; j >= stones[i]; j--) {
                dp[j] = max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[sum / 2];
    }
};