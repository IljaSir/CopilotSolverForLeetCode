class Solution {
public:
    bool isRectangleCover(vector<vector<int>>& rectangles) {
        
        int n = rectangles.size();
        int x1 = INT_MAX, x2 = INT_MIN, y1 = INT_MAX, y2 = INT_MIN;
        int area = 0;
        unordered_set<string> corners;
        for (auto& r : rectangles) {
            x1 = min(x1, r[0]);
            y1 = min(y1, r[1]);
            x2 = max(x2, r[2]);
            y2 = max(y2, r[3]);
            area += (r[2] - r[0]) * (r[3] - r[1]);
            string s1 = to_string(r[0]) + " " + to_string(r[1]);
            string s2 = to_string(r[0]) + " " + to_string(r[3]);
            string s3 = to_string(r[2]) + " " + to_string(r[3]);
            string s4 = to_string(r[2]) + " " + to_string(r[1]);
            if (corners.find(s1) != corners.end()) corners.erase(s1);
            else corners.insert(s1);
            if (corners.find(s2) != corners.end()) corners.erase(s2);
            else corners.insert(s2);
            if (corners.find(s3) != corners.end()) corners.erase(s3);
            else corners.insert(s3);
            if (corners.find(s4) != corners.end()) corners.erase(s4);
            else corners.insert(s4);
        }
        if (corners.size() != 4) return false;
        if (corners.find(to_string(x1) + " " + to_string(y1)) == corners.end()
           || corners.find(to_string(x1) + " " + to_string(y2)) == corners.end()
           || corners.find(to_string(x2) + " " + to_string(y1)) == corners.end()
           || corners.find(to_string(x2) + " " + to_string(y2)) == corners.end()) return false;
        return area == (x2 - x1) * (y2 - y1);
    }
};