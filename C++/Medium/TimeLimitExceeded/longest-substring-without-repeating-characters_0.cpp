class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = max(ans, j - i);
        return ans;
    }
    bool allUnique(string s, int start, int end) {
        vector<bool> chars(256);
        for (int i = start; i < end; i++) {
            if (chars[s[i]]) return false;
            chars[s[i]] = true;
        }
        return true;
    }
};