class Solution {
public:
    int minimumScore(string s, string t) {
        
        int n = s.size();
        int m = t.size();
        vector<int> v(n, 0);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            if (j < m && s[i] == t[j]) {
                v[i] = 1;
                ++j;
            }
        }
        int ans = 0;
        int l = 0, r = m - 1;
        while (l < m && t[l] != s[0]) ++l;
        while (r >= 0 && t[r] != s[n - 1]) --r;
        ans = max(ans, r - l + 1);
        for (int i = 1; i < n; ++i) {
            if (v[i] == 0) {
                ans = max(ans, i);
                continue;
            }
            while (l < m && t[l] != s[i]) ++l;
            while (r >= 0 && t[r] != s[i]) --r;
            ans = max(ans, r - l + 1);
        }
        return ans;
    }
};