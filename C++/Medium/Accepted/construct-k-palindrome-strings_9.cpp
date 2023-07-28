class Solution {
public:
    bool canConstruct(string s, int k) {
        
        if (k > s.size()) return false;
        if (k == s.size()) return true;
        int odd = 0;
        vector<int> cnt(26, 0);
        for (char c : s) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] & 1) odd++;
        }
        return odd <= k;
    }
};