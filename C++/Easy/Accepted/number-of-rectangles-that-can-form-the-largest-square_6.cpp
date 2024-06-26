class Solution {
public:
    int countGoodRectangles(vector<vector<int>>& rectangles) {
        
        int maxLen = 0;
        int cnt = 0;
        for (auto &rect : rectangles) {
            int len = min(rect[0], rect[1]);
            if (len > maxLen) {
                maxLen = len;
                cnt = 1;
            } else if (len == maxLen) {
                ++cnt;
            }
        }
        return cnt;
    }
};