class Solution {
public:
    string largestNumber(vector<int>& cost, int target) {
        
        string ans = "0";
        vector<string> dp(target+1, "");
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < 9; j++) {
                if (i >= cost[j] && dp[i-cost[j]] != "-1") {
                    string temp = dp[i-cost[j]] + to_string(j+1);
                    if (temp.size() > dp[i].size()) {
                        dp[i] = temp;
                    } else if (temp.size() == dp[i].size()) {
                        dp[i] = max(dp[i], temp);
                    }
                }
            }
            if (dp[i].empty()) dp[i] = "-1";
        }
        return dp[target] == "-1" ? "0" : dp[target];
    }
};