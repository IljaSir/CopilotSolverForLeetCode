class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        
        vector<pair<int, int>> v;
        int n = mat.size();
        int m = mat[0].size();
        for (int i = 0; i < n; ++i) {
            int l = 0, r = m;
            while (l < r) {
                int mid = (l + r) / 2;
                if (mat[i][mid] == 0)
                    r = mid;
                else
                    l = mid + 1;
            }
            v.push_back({l, i});
        }
        sort(v.begin(), v.end());
        vector<int> res;
        for (int i = 0; i < k; ++i)
            res.push_back(v[i].second);
        return res;
    }
};