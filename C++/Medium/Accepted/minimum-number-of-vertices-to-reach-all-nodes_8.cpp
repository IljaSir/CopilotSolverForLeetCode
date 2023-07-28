class Solution {
public:
    vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> g(n, vector<int>());
        vector<int> indegree(n, 0);
        for (auto& edge: edges) {
            g[edge[0]].push_back(edge[1]);
            indegree[edge[1]]++;
        }
        vector<int> res;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                res.push_back(i);
            }
        }
        return res;
    }
};