class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int res = 0;
        for (char c = 'A'; c <= 'Z'; ++c) {
            int i = 0, j = 0, count = 0, maxCount = 0;
            while (j < s.size()) {
                if (s[j] == c) {
                    ++count;
                    ++maxCount;
                }
                ++j;
                if (j - i > count + k) {
                    if (s[i] == c) {
                        --maxCount;
                    }
                    ++i;
                }
                res = max(res, j - i);
            }
        }
        return res;
    }
};