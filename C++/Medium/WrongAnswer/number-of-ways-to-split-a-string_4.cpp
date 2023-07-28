class Solution {
public:
    int numWays(string s) {
        
        int n = s.size();
        int one = 0;
        for (char c : s)
            one += c == '1';
        if (one % 3 != 0)
            return 0;
        if (one == 0)
            return (long)(n - 1) * (n - 2) / 2 % 1000000007;
        int k = one / 3, i = 0, j = 0, cnt = 0;
        for (int l = 0; l < n; ++l) {
            if (s[l] == '1') {
                ++cnt;
                if (cnt == k + 1)
                    i = l;
                if (cnt == 2 * k + 1)
                    j = l;
            }
        }
        long res = 1;
        while (i < n - 1 && s[i] == '0') {
            ++i;
            ++res;
        }
        while (j < n - 1 && s[j] == '0') {
            ++j;
            ++res;
        }
        return res % 1000000007;
    }
};