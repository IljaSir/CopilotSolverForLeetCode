class Solution {
public:
    vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges) {
        
        vector<int> res;
        vector<bool> visited(n, false);
        for (auto &e : edges) {
            visited[e[1]] = true;
        }
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) res.push_back(i);
        }
        return res;
    }
};