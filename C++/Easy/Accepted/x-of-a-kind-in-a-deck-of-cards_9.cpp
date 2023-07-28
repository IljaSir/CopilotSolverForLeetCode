class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        
        unordered_map<int,int> m;
        for (auto i:deck) ++m[i];
        int g = 0;
        for (auto i:m) g = gcd(g, i.second);
        return g>1;
    }
};