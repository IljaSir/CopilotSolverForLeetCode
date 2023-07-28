class Solution {
public:
    int longestSubstring(string s, int k) {
        
        int n = s.length();
        if (n < k) return 0;
        vector<int> cnt(26, 0);
        for (auto c : s) cnt[c - 'a']++;
        int i = 0;
        while (i < n && cnt[s[i] - 'a'] >= k) i++;
        if (i == n) return n;
        int left = longestSubstring(s.substr(0, i), k);
        while (i < n && cnt[s[i] - 'a'] < k) i++;
        int right = longestSubstring(s.substr(i), k);
        return max(left, right);
    }
};