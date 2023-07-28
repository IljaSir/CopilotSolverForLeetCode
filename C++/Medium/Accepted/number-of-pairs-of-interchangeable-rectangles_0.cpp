class Solution {
public:
    long long interchangeableRectangles(vector<vector<int>>& rectangles) {
        
        unordered_map<double, int> m;
        for (auto& r : rectangles) {
            m[r[0] * 1.0 / r[1]]++;
        }
        long long res = 0;
        for (auto& p : m) {
            res += (long long)p.second * (p.second - 1) / 2;
        }
        return res;
    }
};