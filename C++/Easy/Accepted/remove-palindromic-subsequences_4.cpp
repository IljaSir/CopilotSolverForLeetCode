class Solution {
public:
    int removePalindromeSub(string s) {
        
        if (s.empty()) {
            return 0;
        }
        int n = s.size();
        for (int i = 0; i < n / 2; ++i) {
            if (s[i] != s[n - 1 - i]) {
                return 2;
            }
        }
        return 1;
    }
};