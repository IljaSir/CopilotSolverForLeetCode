class Solution {
public:
    double largestTriangleArea(vector<vector<int>>& points) {
        
        int n = points.size();
        double ans = 0;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = j + 1; k < n; ++k)
                    ans = max(ans, area(points[i], points[j], points[k]));
        return ans;
    }

    double area(vector<int> &p1, vector<int> &p2, vector<int> &p3) {
        return abs(0.5 * (p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1] - p1[0] * p3[1] - p2[0] * p1[1] - p3[0] * p2[1]));
    }
};