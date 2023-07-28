class Solution {
public:
    int countGoodRectangles(vector<vector<int>>& rectangles) {
        
        int maxLen = 0, res = 0;
        for (auto& rec: rectangles) {
            int len = min(rec[0], rec[1]);
            if (len > maxLen) {
                maxLen = len;
                res = 1;
            } else if (len == maxLen) {
                res++;
            }
        }
        return res;
    }
};