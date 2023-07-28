class Solution {
public:
    int kthSmallest(vector<vector<int>>& mat, int k) {
        
        int m = mat.size(), n = mat[0].size();
        vector<int> v;
        for (int i = 0; i < m; ++i) {
            vector<int> u;
            for (int x : v) {
                for (int y : mat[i]) {
                    u.push_back(x + y);
                }
            }
            sort(u.begin(), u.end());
            v.resize(min(k, (int)u.size()));
            copy(u.begin(), v.end(), v.begin());
        }
        return v[k - 1];
    }
};