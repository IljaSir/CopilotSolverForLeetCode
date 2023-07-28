class Solution {
public:
    long long interchangeableRectangles(vector<vector<int>>& rectangles) {
        
        map<pair<int, int>, int> m;
        for (auto& r : rectangles) {
            int g = gcd(r[0], r[1]);
            m[{r[0]/g, r[1]/g}]++;
        }
        long long res = 0;
        for (auto& p : m) {
            res += p.second * (p.second - 1) / 2;
        }
        return res;
    }
};