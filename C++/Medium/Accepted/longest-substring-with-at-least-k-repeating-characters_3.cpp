class Solution {
public:
    int longestSubstring(string s, int k) {
        
        return longestSubstring(s, 0, s.size(), k);
    }
    int longestSubstring(string &s, int start, int end, int k) {
        if (end - start < k) return 0;
        vector<int> count(26, 0);
        for (int i = start; i < end; i++) {
            count[s[i] - 'a']++;
        }
        int i = start;
        while (i < end && count[s[i] - 'a'] >= k) i++;
        if (i == end) return end - start;
        int left = longestSubstring(s, start, i, k);
        while (i < end && count[s[i] - 'a'] < k) i++;
        int right = longestSubstring(s, i, end, k);
        return max(left, right);
    }
};