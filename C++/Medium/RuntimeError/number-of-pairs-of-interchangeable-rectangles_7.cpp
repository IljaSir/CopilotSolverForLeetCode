class Solution {
public:
    long long interchangeableRectangles(vector<vector<int>>& rectangles) {
        
        unordered_map<double, int> ratioCount;
        for (auto& rect : rectangles) {
            ratioCount[1.0 * rect[0] / rect[1]]++;
        }
        long long res = 0;
        for (auto& [ratio, count] : ratioCount) {
            res += count * (count - 1) / 2;
        }
        return res;
    }
};