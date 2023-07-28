class Solution {
public:
    int countPalindromicSubsequence(string s) {
        
        int res = 0;
        int n = s.size();
        vector<int> first(26, n), last(26, -1);
        for (int i = 0; i < n; ++i) {
            int c = s[i] - 'a';
            first[c] = min(first[c], i);
            last[c] = i;
        }
        for (int c = 0; c < 26; ++c) {
            if (first[c] < last[c]) {
                vector<bool> seen(26, false);
                for (int i = first[c] + 1; i < last[c]; ++i) {
                    seen[s[i] - 'a'] = true;
                }
                for (int i = 0; i < 26; ++i) {
                    if (seen[i]) {
                        ++res;
                    }
                }
            }
        }
        return res;
    }
};