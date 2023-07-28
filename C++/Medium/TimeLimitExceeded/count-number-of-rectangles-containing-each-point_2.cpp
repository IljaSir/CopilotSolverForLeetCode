class Solution {
public:
    vector<int> countRectangles(vector<vector<int>>& rectangles, vector<vector<int>>& points) {
        
        vector<int> res;
        for (auto& p : points) {
            int count = 0;
            for (auto& r : rectangles) {
                if (p[0] <= r[0] && p[1] <= r[1]) {
                    count++;
                }
            }
            res.push_back(count);
        }
        return res;
    }
};