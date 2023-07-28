class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
        
        cuts.push_back(0);
        cuts.push_back(n);
        sort(cuts.begin(), cuts.end());
        int m = cuts.size();
        vector<vector<int>>dp(m, vector<int>(m, 0));
        for(int i = 1; i < m; i++){
            for(int j = i  1; j >= 0; j--){
                if(i - j < 2){
                    dp[j][i] = 0;
                }
                else{
                    dp[j][i] = INT_MAX;
                   for(int k = j + 1; k < i; k++){
                        dp[j][i] = min(dp[j][i], dp[j][k] + dp[k][i]);
                    }
                    dp[j][i] += ] - cuts[j
                }
                dp[i][j] += cuts[j] - cuts[i];
            }
        }[0]m - 1];
    }
};