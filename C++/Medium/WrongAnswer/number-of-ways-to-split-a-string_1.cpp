class Solution {
public:
    int numWays(string s) {
        
        int n = s.size();
        int n1 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') n1++;
        }
        if (n1 == 0) return (long long)(n - 1) * (n - 2) / 2 % 1000000007;
        if (n1 % 3 != 0) return 0;
        n1 /= 3;
        int c1 = 0, c2 = 0, c3 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                c1++;
                if (c1 == n1) c2++;
                if (c1 == n1 * 2) c3++;
            }
        }
        return (long long)(c2 + 1) * (c3 + 1) % 1000000007;
    }
};