class Solution {
public:
    bool hasAllCodes(string s, int k) {
        
        int n = s.size();
        int mask = 1 << k;
        vector<bool> seen(mask, false);
        int hash = 0;
        for (int i = 0; i < n; ++i) {
            hash = hash * 2 + (s[i] - '0');
            hash &= mask - 1;
            if (i >= k - 1 && !seen[hash]) {
                seen[hash] = true;
                --mask;
                if (!mask) {
                    return true;
                }
            }
        }
        return false;
    }
};