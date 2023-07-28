class Solution {
public:
    int minCharacters(string a, string b) {
        
        int n = a.size(), m = b.size();
        vector<int> cnta(26, 0), cntb(26, 0);
        for (auto c : a) ++cnta[c - 'a'];
        for (auto c : b) ++cntb[c - 'a'];
        int ans = n + m;
        for (int i = 0; i < 25; ++i) {
            ans = min(ans, n + m - cnta[i] - cntb[i]);
            ans = min(ans, n - cnta[i] + cntb[i]);
            ans = min(ans, m - cntb[i] + cnta[i]

        int n = a.size();
        int m = b.size();
        vector<int> f1(26, 0);
        vector<int> f2(26, 0);
        for (int i = 0; i < n; i++) {
            f1[a[i] - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            f2[b[i] - 'a']++;
        }
        int ans = n + m;
        for (int i = 0; i < 26; i++) {
            // condition 3
            ans = min(ans, n + m - f1[i] - f2[i]);
            if (i > 0) {
                // condition 1
                f1[i] += f1[i - 1];
                ans = min(ans, n + m - f1[i] - f2[i - 1]);
                // condition 2
                f2[i] += f2[i - 1];
                ans = min(ans, n + m - f1[i - 1] - f2[i]);
            }
        }
        return ans;
    }
};