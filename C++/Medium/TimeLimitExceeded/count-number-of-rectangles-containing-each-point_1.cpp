class Solution {
public:
    vector<int> countRectangles(vector<vector<int>>& rectangles, vector<vector<int>>& points) {
        
        vector<int> result;
        for (int i = 0; i < points.size(); ++i) {
            int count = 0;
            for (int j = 0; j < rectangles.size(); ++j) {
                if (rectangles[j][0] >= points[i][0] && rectangles[j][1] >= points[i][1]) {
                    count++;
                }
            }
            result.push_back(count);
        }
        return result;
    }
};