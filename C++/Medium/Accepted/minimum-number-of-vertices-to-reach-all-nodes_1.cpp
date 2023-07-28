class Solution {
public:
    vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges) {
        
        vector<int> indegrees(n, 0);
        for (auto& edge : edges) {
            indegrees[edge[1]]++;
        }
        vector<int> ret;
        for (int i = 0; i < n; ++i) {
            if (indegrees[i] == 0) {
                ret.push_back(i);
            }
        }
        return ret;
    }
};