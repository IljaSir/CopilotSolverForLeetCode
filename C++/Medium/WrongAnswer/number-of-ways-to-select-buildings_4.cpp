class Solution {
public:
    long long numberOfWays(string s) {
        
        int n = s.size();
        int cnt = count(s.begin(), s.end(), '1');
        if (cnt % 3) return 0;
        if (cnt == 0) {
            return (n - 2) * 1ll * (n - 1) / 2 % 1000000007;
        }
        cnt /= 3;
        int i = 0, j = 0;
        int c = 0;
        int p1, p2;
        while (i < n) {
            if (s[i] == '1') {
                c++;
            }
            if (c == cnt) {
                p1 = i;
                break;
            }
            i++;
        }
        while (j < n) {
            if (s[j] == '1') {
                c--;
            }
            if (c == 0) {
                p2 = j;
                break;
            }
            j++;
        }
        long long ans = (p1 + 1) * 1ll * (n - p2) % 1000000007;
        while (j < n) {
            if (s[j] == '1') {
                c--;
            }
            if (c == cnt) {
                ans = ans * (j - p2) % 1000000007;
                p2 = j;
            }
            j++;
        }
        return ans;
    }
};