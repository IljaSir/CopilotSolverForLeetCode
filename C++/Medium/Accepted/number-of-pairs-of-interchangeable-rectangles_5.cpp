class Solution {
public:
    long long interchangeableRectangles(vector<vector<int>>& rectangles) {
        
        long long ans = 0;
        unordered_map<double, int> mp;
        for (auto& r : rectangles) {
            double ratio = (double)r[0] / r[1];
            ans += mp[ratio];
            ++mp[ratio];
        }
        return ans;
    }
};