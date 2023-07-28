class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        
        vector<int> in(n, 0);
        vector<vector<bool>> adj(n, vector<bool>(n, false));
        for (auto r : roads) {
            in[r[0]]++;
            in[r[1]]++;
            adj[r[0]][r[1]] = true;
            adj[r[1]][r[0]] = true;
        }
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = in[i] + in[j];
                if (adj[i][j]) rank--;
                maxRank = max(maxRank, rank);
            }
        }
        return maxRank;
    }
};