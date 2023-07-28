class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& image) {
        
        int n = image.size();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int tmp = image[i][j] ^ 1;
                image[i][j] = image[i][n - 1 - j] ^ 1;
                image[i][n - 1 - j] = tmp;
            }
        }
        return image;
    }
};