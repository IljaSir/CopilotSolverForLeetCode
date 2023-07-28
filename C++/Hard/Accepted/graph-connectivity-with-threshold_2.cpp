class Solution {
public:
    vector<bool> areConnected(int n, int threshold, vector<vector<int>>& queries) {
        
        vector<bool> result(queries.size(), false);
        vector<int> parent(n + 1, 0);
        for (int i = 0; i < parent.size(); ++i) {
            parent[i] = i;
        }
        for (int i = threshold + 1; i <= n; ++i) {
            for (int j = i; j <= n; j += i) {
                unionSet(parent, i, j);
            }
        }
        for (int i = 0; i < queries.size(); ++i) {
            result[i] = findSet(parent, queries[i][0]) == findSet(parent, queries[i][1]);
        }
        return result;
    }
    
    int findSet(vector<int>& parent, int x) {
        if (parent[x] != x) {
            parent[x] = findSet(parent, parent[x]);
        }
        return parent[x];
    }
    
    void unionSet(vector<int>& parent, int x, int y) {
        int px = findSet(parent, x);
        int py = findSet(parent, y);
        if (px != py) {
            parent[py] = px;
        }
    }
};