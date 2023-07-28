class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        int n = s.length();
        if (n == 0 || n == 1) return n;
        int maxLen = 0;
        int i = 0;
        int j = 0;
        unordered_set<char> m;
        while (i < n && j < n) {
            if (m.find(s[j]) == m.end()) {
                m.insert(s[j++]);
                maxLen = max(maxLen, j - i);
            } else {
                m.erase(s[i++]);
            }
        }
        return maxLen;
    }
};