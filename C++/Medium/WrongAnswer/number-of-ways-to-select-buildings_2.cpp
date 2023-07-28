class Solution {
public:
    long long numberOfWays(string s) {
        
        int n = s.size();
        int cnt = 0;
        for (char c : s) {
            if (c == '1') cnt++;
        }
        if (cnt % 3 != 0) return 0;
        if (cnt == 0) {
            return (long long)(n - 1) * (n - 2) / 2 % 1000000007;
        }
        int k = cnt / 3;
        int i = 0;
        int j = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        while (i < n && cnt1 < k) {
            if (s[i] == '1') cnt1++;
            i++;
        }
        while (i < n && s[i] == '0') i++;
        j = i;
        while (j < n && cnt2 < k) {
            if (s[j] == '1') cnt2++;
            j++;
        }
        return (long long)(i - cnt1) * (j - i) % 1000000007;
    }
};