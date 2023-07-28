class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& image) {
        
        for (int i = 0; i < image.size(); i++) {
            for (int j = 0; j < image[i].size() / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][image[i].size() - j - 1];
                image[i][image[i].size() - j - 1] = temp;
            }
            for (int j = 0; j < image[i].size(); j++) {
                image[i][j] = image[i][j] ^ 1;
            }
        }
        return image;
    }
};