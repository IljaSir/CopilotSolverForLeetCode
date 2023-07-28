class Solution {
public:
    bool isRectangleCover(vector<vector<int>>& rectangles) {
        
        int n = rectangles.size();
        set<pair<int, int>> points;
        int left = INT_MAX, bottom = INT_MAX, right = INT_MIN, top = INT_MIN;
        int area = 0;
        for (auto& r: rectangles) {
            left = min(left, r[0]);
            bottom = min(bottom, r[1]);
            right = max(right, r[2]);
            top = max(top, r[3]);
            area += (r[2] - r[0]) * (r[3] - r[1]);
            if (points.count({r[0], r[1]})) points.erase({r[0], r[1]});
            else points.insert({r[0], r[1]});
            if (points.count({r[0], r[3]})) points.erase({r[0], r[3]});
            else points.insert({r[0], r[3]});
            if (points.count({r[2], r[1]})) points.erase({r[2], r[1]});
            else points.insert({r[2], r[1]});
            if (points.count({r[2], r[3]})) points.erase({r[2], r[3]});
            else points.insert({r[2], r[3]});
        }
        if (points.size() != 4) return false;
        if (points.count({left, bottom}) == 0) return false;
        if (points.count({left, top}) == 0) return false;
        if (points.count({right, bottom}) == 0) return false;
        if (points.count({right, top}) == 0) return false;
        return area == (right - left) * (top - bottom);
    }
};