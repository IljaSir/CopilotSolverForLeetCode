class Solution {
public:
    long long interchangeableRectangles(vector<vector<int>>& rectangles) {
        
        map<double, long long> mp;
        for (auto & r : rectangles) {
            mp[r[0] * 1.0 / r[1]]++;
        }
        long long ans = 0;
        for (auto & p : mp) {
            ans += p.second * (p.second - 1) / 2;
        }
        return ans;
    }
};