class Solution {
public:
    int countGoodRectangles(vector<vector<int>>& rectangles) {
        
        int maxLen = 0, cnt = 0;
        for (auto& r : rectangles) {
            int len = min(r[0], r[1]);
            if (len > maxLen) {
                maxLen = len;
                cnt = 1;
            } else if (len == maxLen) {
                cnt++;
            }
        }
        return cnt;
    }
};