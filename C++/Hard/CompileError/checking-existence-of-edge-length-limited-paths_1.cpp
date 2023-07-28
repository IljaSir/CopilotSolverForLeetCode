class Solution {
public:
    vector<bool> distanceLimitedPathsExist(int n, vector<vector<int>>& edgeList, vector<vector<int>>& queries) {
        
        vector<int> parent(n, 0);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        vector<int> rank(n, 1);
        auto cmp = [](const vector<int>& a, const vector<int>& b) {
            return a[2] < b[2];
        };
        sort(edgeList.begin(), edgeList.end(), cmp);
        vector<vector<int>> newQueries;
        for (int i = 0; i < queries.size(); ++i) {
            newQueries.push_back({queries[i][0], queries[i][1], queries[i][2], i});
        }
        sort(newQueries.begin(), newQueries.end(), cmp);
        vector<bool> ans(queries.size(), false);
        int edgeIndex = 0;
        for (int i = 0; i < newQueries.size(); ++i) {
            while (edgeIndex < edgeList.size() && edgeList[edgeIndex][2] < newQueries[i][2]) {
                int u = edgeList[edgeIndex][0];
                int v = edgeList[edgeIndex][1];
                int pu = find(u, parent);
                int pv = find(v, parent);
                if (pu != pv) {
                    if (rank[pu] > rank[pv]) {
                        swap(pu, pv);
                    }
                    parent[pu] = pv;
                    rank[pv] += rank[pu];
                }
                ++edgeIndex;
            }
            int pu = find(newQueries[i][0], parent);
            int pv = find(newQueries[i][1], parent);
            if (pu == pv) {
                ans[newQueries[i][3]] = true;
            }
        }
        return ans;
    }
};