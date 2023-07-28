class Solution {
public:
    int countGoodRectangles(vector<vector<int>>& rectangles) {
        
        int maxLen = 0;
        int count = 0;
        for (auto& rect : rectangles) {
            int minLen = rect[0] < rect[1] ? rect[0] : rect[1];
            if (minLen > maxLen) {
                maxLen = minLen;
                count = 1;
            } else if (minLen == maxLen) {
                count++;
            }
        }
        return count;
    }
};