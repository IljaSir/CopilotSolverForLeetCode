class Solution {
public:
    long long numberOfWays(string s) {
        
        int n = s.size();
        int cnt = 0;
        for (auto c : s) {
            if (c == '1') {
                cnt++;
            }
        }
        if (cnt % 3 != 0) {
            return 0;
        }
        if (cnt == 0) {
            long long m = n - 2;
            return m * (m - 1) / 2 % 1000000007;
        }
        int k = cnt / 3;
        int i = 0, j = 0;
        int cnt1 = 0;
        while (cnt1 < k) {
            if (s[i] == '1') {
                cnt1++;
            }
            i++;
        }
        int cnt2 = 0;
        while (cnt2 < k) {
            if (s[j] == '1') {
                cnt2++;
            }
            j++;
        }
        while (s[i] == '0') {
            i++;
        }
        while (s[j] == '0') {
            j++;
        }
        return (long long)(i - cnt1) * (n - j) % 1000000007;
    }
};