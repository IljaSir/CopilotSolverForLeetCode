class Solution {
public:
    bool isRectangleCover(vector<vector<int>>& rectangles) {
        
        int x1 = INT_MAX, y1 = INT_MAX, x2 = INT_MIN, y2 = INT_MIN;
        set<pair<int, int>> st;
        int area = 0;
        for (auto& r : rectangles) {
            x1 = min(x1, r[0]);
            y1 = min(y1, r[1]);
            x2 = max(x2, r[2]);
            y2 = max(y2, r[3]););
    }
};