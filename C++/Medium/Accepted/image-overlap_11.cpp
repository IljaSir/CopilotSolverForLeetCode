class Solution {
public:
    int largestOverlap(vector<vector<int>>& img1, vector<vector<int>>& img2) {
        
        int len = img1.size();
        vector<vector<int>> arr(2 * len - 1, vector<int>(2 * len - 1, 0));
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                if (img1[i][j] == 1) {
                    for (int k = 0; k < len; ++k) {
                        for (int l = 0; l < len; ++l) {
                            if (img2[k][l] == 1) {
                                arr[i - k + len - 1][j - l + len - 1]++;
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (auto& v : arr) {
            for (int i : v) {
                res = max(res, i);
            }
        }
        return res;
    }
};