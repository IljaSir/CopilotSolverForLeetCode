class Solution {
public:
    bool canConstruct(string s, int k) {
        
        int n = s.size();
        if (n < k) return false;
        if (n == k) return true;
        vector<int> cnt(26);
        for (int i = 0; i < n; ++i) {
            ++cnt[s[i] - 'a'];
        }
        int odd = 0;
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] % 2 == 1) {
                ++odd;
            }
        }
        return odd <= k;
    }
};