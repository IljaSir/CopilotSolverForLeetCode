class Solution {
public:
    int largestOverlap(vector<vector<int>>& img1, vector<vector<int>>& img2) {
        
        int n = img1.size();
        vector<vector<int>> v(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            if (img2[k][l] == 1) {
                                v[k - i + n - 1][l - j + n - 1]++;
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (auto vi : v) {
            for (auto vij : vi) {
                res = max(res, vij);
            }
        }
        return res;
    }
};