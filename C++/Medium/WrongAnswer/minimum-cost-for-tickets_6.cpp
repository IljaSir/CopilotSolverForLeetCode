class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        
        int n = days.size();
        int dp[n+1];
        dp[n] = 0;
        int j = 0;
        for(int i = n-1; i >= 0; i--){
            dp[i] = INT_MAX;
            for(int k = 0; k < 3; k++){
                while(j < n && days[j] < days[i] + (k == 0 ? 1 : k == 1 ? 7 : 30)) j++;
                dp[i] = min(dp[i], dp[j] + costs[k]);
            }
        }
        return dp[0];
    }
};