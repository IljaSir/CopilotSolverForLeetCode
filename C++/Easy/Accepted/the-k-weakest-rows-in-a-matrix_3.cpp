class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        
        vector<pair<int, int>> v;
        for (int i = 0; i < mat.size(); i++) {
            int j = 0;
            for (; j < mat[i].size(); j++) {
                if (mat[i][j] == 0) {
                    break;
                }
            }
            v.push_back({j, i});
        }
        sort(v.begin(), v.end());
        vector<int> ans;
        for (int i = 0; i < k; i++) {
            ans.push_back(v[i].second);
        }
        return ans;
    }
};