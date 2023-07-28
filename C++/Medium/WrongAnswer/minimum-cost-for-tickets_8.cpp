class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        
        int n = days.size();
        int dp[n+1];
        dp[0] = 0;
        int i=0, j=0;
        while(i<n){
            int d1 = days[i] + 1;
            int d2 = days[i] + 7;
            int d3 = days[i] + 30;
            int next = min({d1, d2, d3});
            while(j<n && days[j]<next){
                j++;
            }
            dp[i+1] = min(dp[i] + costs[0], min(dp[j] + costs[1], dp[upper_bound(days.begin(), days.end(), days[i] + 29) - days.begin()] + costs[2]));
            i++;
        }
        return dp[n];
    }
};