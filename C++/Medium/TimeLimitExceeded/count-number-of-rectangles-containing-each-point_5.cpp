class Solution {
public:
    vector<int> countRectangles(vector<vector<int>>& rectangles, vector<vector<int>>& points) {
        
        vector<int> ret;
        for (auto& point : points) {
            int count = 0;
            for (auto& rect : rectangles) {
                if (point[0] <= rect[0] && point[1] <= rect[1]) {
                    count++;
                }
            }
            ret.push_back(count);
        }
        return ret;
    }
};