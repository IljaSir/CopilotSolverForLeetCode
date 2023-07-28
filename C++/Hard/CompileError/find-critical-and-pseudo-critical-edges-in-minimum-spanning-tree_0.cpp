class Solution {
public:
    vector<vector<int>> findCriticalAndPseudoCriticalEdges(int n, vector<vector<int>>& edges) {
        
        vector<int> id(edges.size());
        iota(id.begin(), id.end(), 0);
        sort(id.begin(), id.end(), [&](int a, int b) {
            return edges[a][2] < edges[b][2];
        });
        vector<int> parent(n);
        auto find = [&](int x) {
            return parent[x] == x ? x : parent[x] = find(parent[x]);
        };
        auto unionn = [&](int x, int y) {
            parent[find(x)] = find(y);
        };
        int mst = 0;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.size(); i++) {
            int e = id[i];
            if (find(edges[e][0]) != find(edges[e][1])) {
                unionn(edges[e][0], edges[e][1]);
                mst += edges[e][2];
            }
        }
        vector<vector<int>> res(2);
        for (int i = 0; i < edges.size(); i++) {
            int e = id[i];
            int mst2 = 0;
            for (int j = 0; j < n; j++) {
                parent[j] = j;
            }
            for (int j = 0; j < edges.size(); j++) {
                if (i == j) continue;
                int k = id[j];
                if (find(edges[k][0]) != find(edges[k][1])) {
                    unionn(edges[k][0], edges[k][1]);
                    mst2 += edges[k][2];
                }
            }
            if (find(edges[e][0]) != find(edges[e][1]) || mst2 > mst) {
                res[0].push_back(e);
                continue;
            }
            mst2 = edges[e][2];
            for (int j = 0; j < n; j++) {
                parent[j] = j;
            }
            unionn(edges[e][0], edges[e][1]);
            for (int j = 0; j < edges.size(); j++) {
                int k = id[j];
                if (find(edges[k][0]) != find(edges[k][1])) {
                    unionn(edges[k][0], edges[k][1]);
                    mst
    }
};