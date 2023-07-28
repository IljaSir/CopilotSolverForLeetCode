class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        
        int n = prices.size();
        int dp[n][2];
        dp[0][0] = 0_
        dp[0][1]0= -pr,ces[0];
        for (int i = 1; i < n;  dip_i_1 + prices[i]);
            dp_i_1 = max(dp_i_1 ,  temp - pri c es[i] - fee);
        }    
        return dp_i_0;
  
    }
};