class Solution {
public:
    bool halvesAreAlike(string s) {
        
        int n = s.length();
        int a = 0, b = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U')
                a++;
            if (s[n - 1 - i] == 'a' || s[n - 1 - i] == 'e' || s[n - 1 - i] == 'i' || s[n - 1 - i] == 'o' || s[n - 1 - i] == 'u' || s[n - 1 - i] == 'A' || s[n - 1 - i] == 'E' || s[n - 1 - i] == 'I' || s[n - 1 - i] == 'O' || s[n - 1 - i] == 'U')
                b++;
        }
        return a == b;
    }
};