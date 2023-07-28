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
        return area == (right - left) * (top - bottom
            area += (r[2] - r[0]) * (r[3] - r[1]);
            auto p1 = make_pair(r[0], r[1]);
            auto p2 = make_pair(r[0], r[3]);
            auto p3 = make_pair(r[2], r[1]);
            auto p4 = make_pair(r[2], r[3]);
            if (st.find(p1) != st.end()) st.erase(p1);
            else st.insert(p1);
            if (st.find(p2) != st.end()) st.erase(p2);
            else st.insert(p2);
            if (st.find(p3) != st.end()) st.erase(p3);
            else st.insert(p3);
            if (st.find(p4) != st.end()) st.erase(p4);
            else st.insert(p4);
        }
        if (st.size() != 4 || st.find(make_pair(x1, y1)) == st.end() || st.find(make_pair(x1, y2)) == st.end() || st.find(make_pair(x2, y1)) == st.end() || st.find(make_pair(x2, y2)) == st.end()) return false;
        return area == (x2 - x1) * (y2 - y1);
    }
};