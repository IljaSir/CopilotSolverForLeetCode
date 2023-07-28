class Solution {
public:
    int longestSubstring(string s, int k) {
        
        int n = s.size();
        if (n == 0) return 0;
        if (k == 1) return n;
        int cnt[26] = {0};
        for (int i = 0; i < n; i++) {
            cnt[s[i] - 'a']++;
        }
        int start = 0;
        while (start < n && cnt[s[start] - 'a'] >= k) {
            start++;
        }
        if (start == n) return n;
        int left = longestSubstring(s.substr(0, start), k);
        while (start < n && cnt[s[start] - 'a'] < k) {
            start++;
        }
        int right = longestSubstring(s.substr(start), k);
        return max(left, right);
    }
};