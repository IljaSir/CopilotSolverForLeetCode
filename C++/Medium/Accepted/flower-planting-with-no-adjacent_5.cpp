class Solution {
public:
    vector<int> gardenNoAdj(int n, vector<vector<int>>& paths) {
        
        vector<vector<int>> adj(n);
        for (auto &p : paths) {
            adj[p[0]-1].push_back(p[1]-1);
            adj[p[1]-1].push_back(p[0]-1);
        }
        vector<int> res(n);
        for (int i = 0; i < n; ++i) {
            vector<int> used(5);
            for (auto &j : adj[i]) {
                used[res[j]] = 1;
            }
            for (int j = 1; j <= 4; ++j) {
                if (!used[j]) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
};