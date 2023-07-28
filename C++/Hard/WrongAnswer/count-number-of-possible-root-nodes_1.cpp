class Solution {
public:
    int rootCount(vector<vector<int>>& edges, vector<vector<int>>& guesses, int k) {
        
        int n = edges.size() + 1;
        vector<int> inDegree(n, 0);
        vector<vector<int>> adj(n, vector<int>());
        for (auto e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
            inDegree[e[0]]++;
            inDegree[e[1]]++;
        }
        vector<int> roots;
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 1) {
                roots.push_back(i);
            }
        }
        int ans = 0;
        for (int i = 0; i < roots.size(); ++i) {
            int cnt = 0;
            for (auto g : guesses) {
                if (g[0] == roots[i]) {
                    cnt++;
                }
            }
            if (cnt >= k) {
                ans++;
            }
        }
        return ans;
    }
};