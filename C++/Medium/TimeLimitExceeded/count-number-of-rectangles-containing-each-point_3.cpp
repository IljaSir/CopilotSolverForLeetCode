class Solution {
public:
    vector<int> countRectangles(vector<vector<int>>& rectangles, vector<vector<int>>& points) {
        
        vector<int> result;
        for (auto& point : points) {
            int count = 0;
            for (auto& rectangle : rectangles) {
                if (point[0] <= rectangle[0] && point[1] <= rectangle[1]) {
                    count++;
                }
            }
            result.push_back(count);
        }
        return result;
    }
};