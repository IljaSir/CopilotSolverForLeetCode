class Solution {
public:
    int countGoodRectangles(vector<vector<int>>& rectangles) {
        
        int maxLen = 0;
        int count = 0;
        for (auto& rectangle : rectangles) {
            int len = min(rectangle[0], rectangle[1]);
            if (len > maxLen) {
                maxLen = len;
                count = 1;
            } else if (len == maxLen) {
                count++;
            }
        }
        return count;
    }
};