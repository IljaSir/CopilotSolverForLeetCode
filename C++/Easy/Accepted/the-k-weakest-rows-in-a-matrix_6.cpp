class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        
        vector<int> res;
        vector<pair<int, int>> v;
        for (int i = 0; i < mat.size(); i++) {
            v.push_back({count(mat[i].begin(), mat[i].end(), 1), i});
        }
        sort(v.begin(), v.end());
        for (int i = 0; i < k; i++) {
            res.push_back(v[i].second);
        }
        return res;
    }
};