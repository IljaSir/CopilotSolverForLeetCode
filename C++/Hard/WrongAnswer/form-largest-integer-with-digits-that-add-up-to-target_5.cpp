class Solution {
public:
    string largestNumber(vector<int>& cost, int target) {
        
        int n = cost.size();
        vector<int> dp(target+1, INT_MIN);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = cost[i]; j <= target; ++j) {
                dp[j] = max(dp[j], dp[j-cost[i]] + 1);
            }
        }
        if (dp[target] < 0) return "0";
        string res;
        for (int i = n-1, j = target; i >= 0; --i) {
            for (int k = 9; k > 0; --k) {
                int nj = j - k * cost[i];
                if (nj >= 0 && dp[nj] >= 0 && dp[nj] == dp[j] - 1) {
                    res += to_string(k);
                    j = nj;
                    break;
                }
            }
        }
        return res;
    }
};