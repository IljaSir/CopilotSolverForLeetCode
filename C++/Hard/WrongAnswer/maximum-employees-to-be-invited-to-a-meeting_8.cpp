class Solution {
public:
    int maximumInvitations(vector<int>& favorite) {
        
        int n = favorite.size();
        vector<int> next(n, -1);
        vector<bool> visited(n, false);
        for(int i = 0; i < n; i++){
            int cur = i;
            while(!visited[cur]){
                visited[cur] = true;
                cur = favorite[cur];
            }
            next[i] = cur;
        }
        vector<int> dp(1 << n, -1);
        dp[0] = 0;
        for(int mask = 1; mask < (1 << n); mask++){
            int i = __builtin_ctz(mask);
            int t = mask ^ (1 << i);
            if(dp[t] >= 0 && next[i] != -1 && (t & (1 << next[i]))){
                dp[mask] = dp[t] + 1;
            }
            for(int j = i + 1; j < n; j++){
                if(mask & (1 << j)){
                    dp[mask] = max(dp[mask], dp[mask ^ (1 << j)]);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
};