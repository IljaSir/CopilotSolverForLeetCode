class Solution {
public:
    int minimumScore(string s, string t) {
        
        int n = s.size();
        vector<int> l(n), r(n);
        l[0] = s[0] != t[0];
        r[n - 1] = s[n - 1] != t[n - 1];
        for (int i = 1; i < n; ++i) {
            l[i] = l[i - 1] + (s[i] != t[i]);
            r[n - i - 1] = r[n - i] + (s[n - i - 1] != t[n - i - 1]);
        }
        int ans = l[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            ans = min(ans, l[i] + r[i + 1]);
        }
        return ans;
    }
};