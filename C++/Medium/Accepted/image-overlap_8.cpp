class Solution {
public:
    int largestOverlap(vector<vector<int>>& img1, vector<vector<int>>& img2) {
        
        int n = img1.size();
        vector<vector<int>> M(2*n+1, vector<int>(2*n+1, 0));
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if (img1[i][j] == 1) {
                    for(int x = 0; x < n; ++x) {
                        for(int y = 0; y < n; ++y) {
                            if (img2[x][y] == 1) {
                                M[x-i+n][y-j+n]++;
                            }
                        }
                    }
                }
            }
        }
        int result = 0;
        for(int i = 0; i < M.size(); ++i) {
            for(int j = 0; j < M[0].size(); ++j) {
                result = max(result, M[i][j]);
            }
        }
        return result;
    }
};