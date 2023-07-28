class Solution {
public:
    long long interchangeableRectangles(vector<vector<int>>& rectangles) {
        
        unordered_map<double, int> m;
        for (auto& r : rectangles)
            m[1.0 * r[0] / r[1]]++;
        long long res = 0;
        for (auto& [k, v] : m)
            res += 1LL * v * (v - 1) / 2;
        return res;
    }
};