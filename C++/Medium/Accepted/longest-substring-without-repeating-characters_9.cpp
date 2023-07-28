class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        int len = s.length();
        if (len <= 1) return len;
        int max = 0;
        int i = 0, j = 1;
        while (j < len) {
            char c = s[j];
            int k = s.find(c, i);
            if (k < j) {
                if (j - i > max) max = j - i;
                i = k + 1;
            }
            j++;
        }
        if (j - i > max) max = j - i;
        return max;
    }
};