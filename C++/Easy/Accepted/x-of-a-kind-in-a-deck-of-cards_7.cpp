class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        
        int n = deck.size();
        unordered_map<int, int> m;
        for (auto x : deck) m[x]++;
        int g = -1;
        for (auto& p : m) {
            if (g == -1) g = p.second;
            else g = gcd(g, p.second);
        }
        return g >= 2;
    }
};