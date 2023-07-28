class Solution {
public:
    bool isRectangleCover(vector<vector<int>>& rectangles) {
        
        int n = rectangles.size()(r[0]) + " " + to_string(r[3]);
            string p3 = to_string(r[2]) + " " + to_string(r[3]);
            string p4 = to_string(r[2]) + " " + to_string(r[1]);
            if (points.count(p1)) points.erase(p1);
            else points.insert(p1);
            if (points.count(p2)) points.erase(p2);
            else points.insert(p2);
            if (points.count(p3)) points.erase(p3);
            else points.insert(p3);
            if (points.count(p4)) points.erase(p4);
            else points.insert(p4);
        }
        if (!points.count(to_string(x1) + " " + to_string(y1)) ||
            !points.count(to_string(x1) + " " + to_string(y2)) ||
            !points.count(to_string(x2) + " " + to_string(y1)) ||
            !points.count(to_string(x2) + " " + to_string(y2)) ||
            points.size() != 4) return false;
        return area == (x2 - x1) * (y2 - y1);
    }
};