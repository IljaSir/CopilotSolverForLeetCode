class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        
        int n = s.size();
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                int m = n / i;
                string t = s.substr(0, i);
                int j;
                for (j = 1; j < m; j++) {
                    if (s.substr(j * i, i) != t) {
                        break;
                    }
                }
                if (j == m) {
                    return true;
                }
            }
        }
        return false;
    }
};