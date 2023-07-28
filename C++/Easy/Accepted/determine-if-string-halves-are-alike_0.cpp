class Solution {
public:
    bool halvesAreAlike(string s) {
        
        int n = s.size();
        int a = 0, b = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U') {
                a++;
            }
            if (s[n - i - 1] == 'a' || s[n - i - 1] == 'e' || s[n - i - 1] == 'i' || s[n - i - 1] == 'o' || s[n - i - 1] == 'u' || s[n - i - 1] == 'A' || s[n - i - 1] == 'E' || s[n - i - 1] == 'I' || s[n - i - 1] == 'O' || s[n - i - 1] == 'U') {
                b++;
            }
        }
        return a == b;
    }
};