class Solution {
public:
    int countPalindromicSubsequence(string s) {
        
        int n = s.size();
        vector<int> left(26, n), right(26, -1);
        for (int i = 0; i < n; ++i) {
            int c = s[i] - 'a';
            left[c] = min(left[c], i);
            right[c] = max(right[c], i);
        }
        int res = 0;
        for (int i = 0; i < 26; ++i) {
            if (left[i] < right[i]) {
                vector<int> count(26);
                for (int j = left[i] + 1; j < right[i]; ++j) {
                    count[s[j] - 'a']++;
                }
                for (int j = 0; j < 26; ++j) {
                    if (count[j]) {
                        ++res;
                    }
                }
            }
        }
        return res;
    }
};