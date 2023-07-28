class Solution {
public:
    bool canConstruct(string s, int k) {
        
        if (k > s.size()) return false;
        if (k == s.size()) return true;
        vector<int> cnt(26, 0);
        for (auto c: s) cnt[c-'a']++;
        int odd = 0;
        for (auto c: cnt) if (c%2) odd++;
        return odd <= k;
    }
};