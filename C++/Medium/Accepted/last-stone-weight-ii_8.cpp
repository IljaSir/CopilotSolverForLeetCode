class Solution {
public:
    int lastStoneWeightII(vector<int>& stones) {
        
        int sum = 0;
        for (int& s : stones) sum += s;
        int target = sum / 2;
        vector<int> dp(target + 1, 0);
        for (int& s : stones) {
            for (int i = target; i >= s; i--) {
                dp[i] = max(dp[i], dp[i - s] + s);
            }
        }
        return sum - dp[target] - dp[target];
    }
};