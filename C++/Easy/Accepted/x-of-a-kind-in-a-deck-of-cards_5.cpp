class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        
        map<int, int> m;
        for (auto i: deck) {
            m[i]++;
        }
        int g = -1;
        for (auto [k, v]: m) {
            if (g == -1) {
                g = v;
            } else {
                g = gcd(g, v);
            }
        }
        return g >= 2;
    }
};