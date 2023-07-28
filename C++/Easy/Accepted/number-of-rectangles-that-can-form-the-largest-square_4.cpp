class Solution {
public:
    int countGoodRectangles(vector<vector<int>>& rectangles) {
        
        int maxLen = 0;
        for (auto &r: rectangles) {
            maxLen = max(maxLen, min(r[0], r[1]));
        }
        int cnt = 0;
        for (auto &r: rectangles) {
            if (maxLen == min(r[0], r[1])) {
                cnt++;
            }
        }
        return cnt;
    }
};