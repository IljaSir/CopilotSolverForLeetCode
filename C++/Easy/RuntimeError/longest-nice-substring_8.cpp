class Solution {
public:
    string longestNiceSubstring(string s) {
        
        int n = s.size();
        if (n < 2) return "";
        vector<int> cnt(26, 0);
        for (char ch : s) {
            cnt[ch - 'A']++;
        }
        int split = 0;
        for (; split < n; split++) {
            if (cnt[s[split] - 'A'] == 1) break;
        }
        if (split == n) return s;
        string l = longestNiceSubstring(s.substr(0, split));
        string r = longestNiceSubstring(s.substr(split + 1));
        return l.size() > r.size() ? l : r;
    }
};