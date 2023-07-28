class Solution {
public:
    vector<bool> areConnected(int n, int threshold, vector<vector<int>>& queries) {
        
        vector<int> parent(n + 1, 0);
        vector<int> rank(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int i = threshold + 1; i <= n; ++i) {
            for (int j = 2; j * i <= n; ++j) {
                unionSet(parent, rank, i, i * j);
            }
        }
        vector<bool> res;
        for (auto& q : queries) {
            res.push_back(findSet(parent, q[0]) == findSet(parent, q[1]));
        }
        return res;
    }
};