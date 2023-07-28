class Solution {
public:
    long long interchangeableRectangles(vector<vector<int>>& rectangles) {
        
        map<double, int> mp;
        for (auto& rect : rectangles) {
            mp[(double)rect[0] / rect[1]]++;
        }
        long long ans = 0;
        for (auto& [_, cnt] : mp) {
            ans += (long long)cnt * (cnt - 1) / 2;
        }
        return ans;
    }
};