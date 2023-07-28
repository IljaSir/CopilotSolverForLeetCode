class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& image) {
        
        vector<vector<int>> result;
        for (int i = 0; i < image.size(); i++) {
            vector<int> temp;
            for (int j = image[i].size() - 1; j >= 0; j--) {
                temp.push_back(image[i][j] == 0 ? 1 : 0);
            }
            result.push_back(temp);
        }
        return result;
    }
};