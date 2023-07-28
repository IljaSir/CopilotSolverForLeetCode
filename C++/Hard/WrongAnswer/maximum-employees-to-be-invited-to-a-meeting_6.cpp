class Solution {
public:
    int maximumInvitations(vector<int>& favorite) {
        
        int n = favorite.size();
        vector<int> visited(n, -1);
        vector<int> depth(n, 0);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = max(ans, dfs(i, favorite, visited, depth));
        }
        return ans;
    }
    
    int dfs(int i, vector<int>& favorite, vector<int>& visited, vector<int>& depth) {
        if (visited[i] == 1) return 0;
        if (visited[i] == 0) return depth[i];
        
        visited[i] = 0;
        depth[i] = 1 + dfs(favorite[i], favorite, visited, depth);
        visited[i] = 1;
        return depth[i];
    }
};