class Solution {
public:
    int longestBeautifulSubstring(string word) {
        
        int maxLen = 0;
        char c = 'a';
        int len = 0;
        for (int i = 0; i < word.size(); i++) {
            if (word[i] == c) {
                len++;
            } else if (word[i] > c) {
                c = word[i];
                len++;
            } else {
                if (c == 'u') {
                    maxLen = max(maxLen, len);
                }
                c = word[i];
                len = 1;
            }
        }
        if (c == 'u') {
            maxLen = max(maxLen, len);
        }
        return maxLen;
    }
};