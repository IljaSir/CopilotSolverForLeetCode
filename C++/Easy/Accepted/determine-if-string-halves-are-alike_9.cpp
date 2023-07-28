class Solution {
public:
    bool halvesAreAlike(string s) {
        
        int n = s.length();
        int half = n / 2;
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (i < half) {
                if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U') {
                    a++;
                }
            } else {
                if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U') {
                    b++;
                }
            }
        }
        return a == b;
    }
};