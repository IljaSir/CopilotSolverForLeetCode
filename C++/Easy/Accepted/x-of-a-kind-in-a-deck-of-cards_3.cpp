class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        
        int n = deck.size();
        unordered_map<int, int> m;
        for (auto i : deck) {
            m[i]++;
        }
        int g = -1;
        for (auto i : m) {
            if (g == -1) {
                g = i.second;
            } else {
                g = __gcd(g, i.second);
            }
        }
        return g >= 2;
    }
};