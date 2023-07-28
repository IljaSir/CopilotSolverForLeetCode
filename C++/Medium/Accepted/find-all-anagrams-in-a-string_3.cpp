class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        vector<int> res;
        int n = s.size();
        int m = p.size();
        if (n < m) return res;
        int freq[26] = {0};
        for (int i = 0; i < m; i++) {
            freq[p[i] - 'a']++;
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (freq[s[i] - 'a'] > 0) cnt++;
            freq[s[i] - 'a']--;
        }
        if (cnt == m) res.push_back(0);
        for (int i = m; i < n; i++) {
            if (freq[s[i - m] - 'a'] >= 0) cnt--;
            freq[s[i - m] - 'a']++;
            if (freq[s[i] - 'a'] > 0) cnt++;
            freq[s[i] - 'a']--;
            if (cnt == m) res.push_back(i - m + 1);
        }
        return res;
    }
};