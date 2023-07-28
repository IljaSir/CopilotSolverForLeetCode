class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        vector<int> res;
        int n = s.size();
        int m = p.size();
        if (n < m) return res;
        int cnt[26] = {0};
        for (char c : p) {
            cnt[c - 'a']++;
        }
        int cnt2[26] = {0};
        for (int i = 0; i < m; i++) {
            cnt2[s[i] - 'a']++;
        }
        if (equal(cnt, cnt2)) res.push_back(0);
        for (int i = m; i < n; i++) {
            cnt2[s[i] - 'a']++;
            cnt2[s[i - m] - 'a']--;
            if (equal(cnt, cnt2)) res.push_back(i - m + 1);
        }
        return res;
    }
    bool equal(int *a, int *b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
};