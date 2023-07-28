class Solution {
public:
    string truncateSentence(string s, int k) {
        
        int i = 0;
        while (k > 0 && i < s.length()) {
            if (s[i] == ' ') {
                k--;
            }
            i++;
        }
        if (i < s.length()) {
            s[i] = '\0';
        }
        return s;
    }
};