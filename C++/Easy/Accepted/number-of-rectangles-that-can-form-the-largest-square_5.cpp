class Solution {
public:
    int countGoodRectangles(vector<vector<int>>& rectangles) {
        
        int maxLen = 0, cnt = 0;
        for (auto& rec : rectangles) {
            int len = min(rec[0], rec[1]);
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