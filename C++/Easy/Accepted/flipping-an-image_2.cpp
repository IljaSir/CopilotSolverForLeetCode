class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& image) {
        
        int n = image.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = image[i][j];
                image[i][j] = image[i][n - 1 - j];
                image[i][n - 1 - j] = tmp;
            }
            for (int j = 0; j < n; j++) {
                image[i][j] = !image[i][j];
            }
        }
        return image;
    }
};