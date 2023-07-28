class Solution {
public:
    string reverseVowels(string s) {
        
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (isVowel(s[i]) && isVowel(s[j])) {
                swap(s[i], s[j]);
                ++i;
                --j;
            } else if (!isVowel(s[i])) {
                ++i;
            } else if (!isVowel(s[j])) {
                --j;
            }
        }
        return s;
    }
};