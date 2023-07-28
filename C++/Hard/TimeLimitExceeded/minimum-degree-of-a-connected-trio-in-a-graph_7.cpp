class Solution {
public:
    int minTrioDegree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> nodes(n+1);
        vector<int> degrees(n+1);
        for (auto& edge : edges) {
            nodes[edge[0]].push_back(edge[1]);
            nodes[edge[1]].push_back(edge[0]);
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }
        int ans = INT_MAX;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < nodes[i].size(); ++j) {
                for (int k = j+1; k < nodes[i].size(); ++k) {
                    int a = nodes[i][j];
                    int b = nodes[i][k];
                    if (find(nodes[a].begin(), nodes[a].end(), b) != nodes[a].end()) {
                        ans = min(ans, degrees[i] + degrees[a] + degrees[b] - 6);
                    }
                }
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};