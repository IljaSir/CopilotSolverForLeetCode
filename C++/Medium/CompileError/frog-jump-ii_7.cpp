class Solution {
public:
    int maxJump(vector<int>& stones) {
        
        int n = stones.size();
        vector<int> dp(n, 0);
        for (int i = 1; i < n; ++i) {
            dp[i] = stones[i] - stones[i - 1];
            for (int j = i - 2; j >= 0; --j) {
                if (stones[i] - stones[j] > i - j) {
                    break;
                }
                dp[i] = max(dp[i], min(dp[j], stones[i] - stones[j]));
            }
        }
        return dp.back();
    }
    int frogJump(vector<int>& stones) {
        int n = stones.size();
        vector<int> dp(n, 0);
        for (int i = 1; i < n; ++i) {
            dp[i] = stones[i] - stones[i - 1];
            for (int j = i - 2; j >= 0; --j) {
                if (stones[i] - stones[j] > i - j) {
                    break;
                }
                dp[i] = max(dp[i], min(dp[j], stones[i] - stones[j]));
            }
        }
        return dp.back();
    }
    int frogJump2(vector<int>& stones) {
        int n = stones.size();
        vector<int> dp(n, 0);
        for (int i = 1; i < n; ++i) {
            dp[i] = stones[i] - stones[i - 1];
            for (int j = i - 2; j >= 0; --j) {
                if (stones[i] - stones[j] > i - j) {
                    break;
                }
                dp[i] = max(dp[i], min(dp[j], stones[i] - stones[j]));
            }
        }
        return dp.back();
    }
    int frogJump3(vector<int>& stones) {
        int n = stones.size();
        vector<int> dp(n, 0);
        for (int i = 1; i < n; ++i) {
            dp[i] = stones[i] - stones[i - 1];
            for (int j = i - 2; j >= 0; --j) {
                if (stones[i] - stones[j] > i - j) {
                    break;
                }
                dp[i] = max(dp[i], min(dp[j], stones
    }
};