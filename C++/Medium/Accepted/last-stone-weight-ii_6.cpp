class Solution {
public:
    int lastStoneWeightII(vector<int>& stones) {
        
        int sum = 0;
        for (int stone : stones) sum += stone;
        int target = sum / 2;
        vector<int> dp(target + 1, 0);
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - 2 * dp[target];
    }
};