class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& image) {
        
        int n = image.size();
        for (int i = 0; i < n; ++i)
        {
            int j = 0;
            int k = n - 1;
            while (j < k)
            {
                int tmp = image[i][j];
                image[i][j] = image[i][k];
                image[i][k] = tmp;
                ++j;
                --k;
            }
            for (j = 0; j < n; ++j)
            {
                image[i][j] = image[i][j] ? 0 : 1;
            }
        }
        return image;
    }
};