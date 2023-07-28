class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        
        int n = deck.size();
        unordered_map<int, int> m;
        for (int i = 0; i < n; ++i) {
            m[deck[i]]++;
        }
        int g = -1;
        for (auto it = m.begin(); it != m.end(); ++it) {
            if (g == -1) {
                g = it->second;
            } else {
                g = __gcd(g, it->second);
            }
        }
        return g >= 2;
    }
};