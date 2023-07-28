class Solution {
public:
    bool halvesAreAlike(string s) {
        
        int n = s.length();
        int a = 0, b = 0;
        for (int i = 0; i < n / 2; ++i) {
            if (isVowel(s[i])) ++a;
            if (isVowel(s[n - i - 1])) ++b;
        }
        return a == b;
    }
};