class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        
        int n = mat.size();
        vector<int> ans;
        vector<pair<int, int>> rows(n);
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < mat[i].size(); j++) {
                if (mat[i][j] == 1) {
                    cnt++;
                } else {
                    break;
                }
            }
            rows[i] = {cnt, i};
        }
        sort(rows.begin(), rows.end());
        for (int i = 0; i < k; i++) {
            ans.push_back(rows[i].second);
        }
        return ans;
    }
};