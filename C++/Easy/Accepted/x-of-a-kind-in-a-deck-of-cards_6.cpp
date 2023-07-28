class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        
        unordered_map<int, int> m;
        for (auto i : deck) m[i]++;
        int res = 0;
        for (auto it = m.begin(); it != m.end(); it++) res = gcd(res, it->second);
        return res > 1;
    }
};