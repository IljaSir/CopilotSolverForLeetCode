class Solution {
public:
    int longestSubstring(string s, int k) {
        
        if (s.length() < k) return 0;
        if (k == 1) return s.length();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int m[26] = {0};
            for (int j = i; j < s.length(); j++) {
                m[s[j] - 'a']++;
                int cnt = 0;
                for (int c = 0; c < 26; c++) {
                    if (m[c] > 0 && m[c] < k) {
                        cnt++;
                    }
                }
                if (cnt == 0) {
                    res = max(res, j - i + 1);
                }
            }
        }
        return res;
    }
};