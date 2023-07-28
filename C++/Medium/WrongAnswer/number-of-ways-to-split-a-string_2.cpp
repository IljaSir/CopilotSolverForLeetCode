class Solution {
public:
    int numWays(string s) {
        
        int n = s.size();
        int one = 0;
        for (auto c : s) {
            one += c == '1';
        }
        if (one % 3 != 0) {
            return 0;
        }
        if (one == 0) {
            return (long)(n - 1) * (n - 2) / 2 % 1000000007;
        }
        one /= 3;
        int i = 0, j = 0, k = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                c++;
            }
            if (c == 1) {
                j++;
            }
            if (c == one + 1) {
                k++;
            }
        }
        return (long)j * k % 1000000007;
    }
};