class Solution {
public:
    vector<int> countRectangles(vector<vector<int>>& rectangles, vector<vector<int>>& points) {
        
        vector<int> result;
        for (auto &p: points) {
            int count = 0;
            for (auto &r: rectangles) {
                if (p[0] <= r[0] && p[1] <= r[1]) {
                    count++;
                }
            }
            result.push_back(count);
        }
        return result;
    }
};