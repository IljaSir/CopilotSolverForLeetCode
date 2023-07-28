class Solution {
public:
    string truncateSentence(string s, int k) {
        
        int i = 0;
        int wordCount = 0;
        for (; i < s.length() && wordCount < k; i++) {
            if (s[i] == ' ') {
                wordCount++;
            }
        }
        if (wordCount == k) {
            return s.substr(0, i - 1);
        }
        return s;
    }
};