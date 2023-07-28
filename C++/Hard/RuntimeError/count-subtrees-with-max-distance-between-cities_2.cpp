class Solution {
public:
    vector<int> countSubgraphsForEachDiameter(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n, vector<int>(n));
        for (auto &edge : edges) {
            graph[edge[0] - 1][edge[1] - 1] = 1;
            graph[edge[1] - 1][edge[0] - 1] = 1;
        }
        vector<int> ans(n - 1);
        for (int i = 1; i < (1 << n); ++i) {
            int count = 0;
            int maxDistance = 0;
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    ++count;
                    for (int k = j + 1; k < n; ++k) {
                        if (i & (1 << k)) {
                            maxDistance = max(maxDistance, graph[j][k]);
                        }
                    }
                }
            }
            if (count > 1) {
                ++ans[maxDistance - 1];
            }
        }
        return ans;
    }
};