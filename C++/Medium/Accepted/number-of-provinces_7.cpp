class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        
        const int n = isConnected.size();
        vector<int> visited(n, 0);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                ++res;
            }
        }
        return res;
    }
    
    void dfs(vector<vector<int>>& isConnected, vector<int>& visited, int i) {
        const int n = isConnected.size();
        visited[i] = 1;
        for (int j = 0; j < n; ++j) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                dfs(isConnected, visited, j);
            }
        }
    }
};