class Solution {
public:
    int minCost(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        vector<int> last(n, -1);
        vector<int> count(n, 0);
        vector<int> cost(n, 0);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c = nums[i];
            if (count[c]++ == 0) {
                ans += k;
            }
            cost[i] = ans;
            last[c] = i;
        }
        dp[0] = cost[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + cost[i];
            for (int j = 0; j < n; j++) {
                if (last[j] < i) {
                    continue;
                }
                if (count[j] == 1) {
                    dp[i] = min(dp[i], (i == 1 ? 0 : dp[i - 2]) + cost[i - 1] + k);
                } else {
                    dp[i] = min(dp[i], (i == 1 ? 0 : dp[i - 2]) + cost[i - 1] + k - 1);
                }
            }
        }
        return dp.back()dp3[i][j] = min(dp3[i][j], dp3[l][j - 1] + dp2[l][i]);
                }
            }
        }
        return dp3[m][k];
    }
};