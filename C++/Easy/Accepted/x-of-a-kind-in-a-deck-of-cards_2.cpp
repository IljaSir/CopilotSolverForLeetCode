class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        
        unordered_map<int, int> cnt;
        for (int i : deck) {
            cnt[i]++;
        }
        int x = -1;
        for (auto p : cnt) {
            if (x == -1) {
                x = p.second;
            } else {
                x = gcd(x, p.second);
            }
        }
        return x >= 2;
    }
};