class Solution {
public:
    vector<int> countSubgraphsForEachDiameter(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n);
        for (auto& edge: edges) {
            graph[edge[0]-1].push_back(edge[1]-1);
            graph[edge[1]-1].push_back(edge[0]-1);
        }
        vector<int> result(n-1, 0);
        for (int i = 0; i < (1 << n); i++) {
            if (i & (i - 1)) {
                vector<int> nodes;
                for (int j = 0; j < n; j++) {
                    if (i & (1 << j)) {
                        nodes.push_back(j);
                    }
                }
                vector<vector<int>> path(n, vector<int>(n, n));
                for (int j = 0; j < nodes.size(); j++) {
                    path[nodes[j]][nodes[j]] = 0;
                    for (int k = 0; k < graph[nodes[j]].size(); k++) {
                        path[graph[nodes[j]][k]][nodes[j]] = 1;
                    }
                }
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            path[k][l] = min(path[k][l], path[k][j] + path[j][l]);
                        }
                    }
                }
                int maxDist = 0;
                for (int j = 0; j < nodes.size(); j++) {
                    for (int k = 0; k < nodes.size(); k++) {
                        maxDist = max(maxDist, path[nodes[j]][nodes[k]]);
                    }
                }
                result[maxDist - 1]++;
            }
        }
        return result;
    }
};