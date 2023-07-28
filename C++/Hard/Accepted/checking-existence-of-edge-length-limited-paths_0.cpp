class Solution {
public:
    vector<bool> distanceLimitedPathsExist(int n, vector<vector<int>>& edgeList, vector<vector<int>>& queries) {
        
        for (int i = 0; i < queries.size(); ++i) {
            queries[i].push_back(i);
        }
        sort(queries.begin(), queries.end(), [](const vector<int>& a, const vector<int>& b) { return a[2] < b[2]; });
        sort(edgeList.begin(), edgeList.end(), [](const vector<int>& a, const vector<int>& b) { return a[2] < b[2]; });
        vector<bool> res(queries.size());
        vector<int> p(n);
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        int i = 0, j = 0;
        while (i < queries.size()) {
            while (j < edgeList.size() && edgeList[j][2] < queries[i][2]) {
                int a = edgeList[j][0], b = edgeList[j][1];
                while (p[a] != a) {
                    a = p[a];
                }
                while (p[b] != b) {
                    b = p[b];
                }
                if (a != b) {
                    p[a] = b;
                }
                ++j;
            }
            int a = queries[i][0], b = queries[i][1];
            while (p[a] != a) {
                a = p[a];
            }
            while (p[b] != b) {
                b = p[b];
            }
            res[queries[i][3]] = a == b;
            ++i;
        }
        return res;
    }
};