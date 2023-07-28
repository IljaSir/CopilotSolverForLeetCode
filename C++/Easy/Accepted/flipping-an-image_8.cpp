class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& image) {
        
        for (auto& row : image) {
            std::reverse(row.begin(), row.end());
            for (auto& item : row) {
                item ^= 1;
            }
        }
        return image;
    }
};