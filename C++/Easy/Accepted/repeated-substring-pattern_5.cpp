class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                bool ok = true;
                for (int j = i; j < n; j++) {
                    if (s[j] != s[j - i]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) return true;
            }
        }
        return false;
    }
};