class Solution {
public:
    vector<int> fallingSquares(vector<vector<int>>& positions) {
        
        vector<int> ans;
        vector<int> height(positions.size(), 0);
        int h = 0;
        for (int i = 0; i < positions.size(); i++) {
            int left = positions[i][0];
            int size = positions[i][1];
            int right = left + size;
            height[i] = size;
            for (int j = 0; j < i; j++) {
                int jleft = positions[j][0];
                int jsize = positions[j][1];
                int jright = jleft + jsize;
                if (jleft < right && jright > left) {
                    height[i] = max(height[i], size + height[j]);
                }
            }
            h = max(h, height[i]);
            ans.push_back(h);
        }
        return ans;
    }
};