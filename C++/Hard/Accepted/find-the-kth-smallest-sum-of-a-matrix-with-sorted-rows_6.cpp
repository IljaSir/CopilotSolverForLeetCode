class Solution {
public:
    int kthSmallest(vector<vector<int>>& mat, int k) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<int> prev;
        vector<int> cur;
        prev.push_back(0);
        for (int i = 0; i < m; i++) {
            cur.clear();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < prev.size(); k++) {
                    cur.push_back(prev[k] + mat[i][j]);
                }
            }
            sort(cur.begin(), cur.end());
            prev.clear();
            for (int j = 0; j < k && j < cur.size(); j++) {
                prev.push_back(cur[j]);
            }
        }
        return prev[k-1];
    }
};