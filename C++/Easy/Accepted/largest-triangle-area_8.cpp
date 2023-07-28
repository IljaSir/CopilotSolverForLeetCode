class Solution {
public:
    double largestTriangleArea(vector<vector<int>>& points) {
        
        double area = 0;
        for (auto &p1 : points) {
            for (auto &p2 : points) {
                for (auto &p3 : points) {
                    area = max(area, 0.5 * abs(p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1] - p1[1] * p2[0] - p2[1] * p3[0] - p3[1] * p1[0]));
                }
            }
        }
        return area;
    }
};