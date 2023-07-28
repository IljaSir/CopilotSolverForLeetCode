class Solution {
public:
    int minFlips(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    res++;
                }
            }
        }
        if (res == 0) {
            return 0;
        }
        if (res == m * n) {
            return 1;
        }
        return -1;
    }
};