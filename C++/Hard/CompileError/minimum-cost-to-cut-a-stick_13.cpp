class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
        
        cuts.push_back(0);
        cuts.push_back(n);
        sort(cuts.begin(), cuts.end());
        int N = cuts.size();
        vector<vector<int>> dp(N, vector<int>(N, INT_MAX));
        return dfs(dp, cuts, 0, N - 1);
    }
};