class Solution {
public:
    int maximumScore(vector<int>& scores, vector<vector<int>>& edges) {
        
        int n = scores.size();
        vector<int> adj[n];
        for (auto& e: edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (find(adj[i].begin(), adj[i].end(), j) != adj[i].end() &&
                            find(adj[i].begin(), adj[i].end(), k) != adj[i].end() &&
                            find(adj[i].begin(), adj[i].end(), l) != adj[i].end() &&
                            find(adj[j].begin(), adj[j].end(), k) != adj[j].end() &&
                            find(adj[j].begin(), adj[j].end(), l) != adj[j].end() &&
                            find(adj[k].begin(), adj[k].end(), l) != adj[k].end()) {
                            res = max(res, scores[i] + scores[j] + scores[k] + scores[l]);
                        }
                    }
                }
            }
        }
        return res;
    }
};