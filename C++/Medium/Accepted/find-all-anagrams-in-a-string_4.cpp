class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        vector<int> res;
        if (s.length() < p.length()) return res;
        int n = s.length(), m = p.length();
        vector<int> cnt(26, 0);
        for (char c : p) cnt[c - 'a']++;
        int l = 0, r = 0, diff = m;
        while (r < n) {
            if (cnt[s[r] - 'a'] > 0) {
                diff--;
            }
            cnt[s[r] - 'a']--;
            r++;
            if (diff == 0) res.push_back(l);
            if (r - l == m) {
                if (cnt[s[l] - 'a'] >= 0) {
                    diff++;
                }
                cnt[s[l] - 'a']++;
                l++;
            }
        }
        return res;
    }
};