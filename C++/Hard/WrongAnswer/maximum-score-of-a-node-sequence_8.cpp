class Solution {
public:
    int maximumScore(vector<int>& scores, vector<vector<int>>& edges) {
        
        int n = scores.size();
        vector<vector<int>> graph(n, vector<int>());
        for(auto& edge: edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<vector<int>> dp(n, vector<int>(n, INT_MIN));
        int ans = INT_MIN;
        for(int i = 0; i < n; i++) {
            dp[i][i] = scores[i];
            for(int j = 0; j < graph[i].size(); j++) {
                int k = graph[i][j];
                if(dp[i][k] == INT_MIN) {
                    dp[i][k] = dp[k][i] = scores[k];
                }
                for(int l = 0; l < graph[k].size(); l++) {
                    int m = graph[k][l];
                    if(dp[i][m] == INT_MIN) {
                        dp[i][m] = dp[m][i] = scores[m];
                    }
                    for(int o = 0; o < graph[m].size(); o++) {
                        int p = graph[m][o];
                        if(dp[i][p] == INT_MIN) {
                            dp[i][p] = dp[p][i] = scores[p];
                        }
                        for(int q = 0; q < graph[p].size(); q++) {
                            int r = graph[p][q];
                            if(dp[i][r] == INT_MIN) {
                                dp[i][r] = dp[r][i] = scores[r];
                            }
                            if(dp[i][k] != INT_MIN && dp[k][m] != INT_MIN && dp[m][p] != INT_MIN && dp[p][r] != INT_MIN) {
                                ans = max(ans, dp[i][k] + dp[k][m] + dp[m][p] + dp[p][r] - scores[i] - scores[k] - scores[m] - scores[p] - scores[r]);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
};