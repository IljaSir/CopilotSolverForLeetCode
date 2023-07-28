class Solution {
public:
    string shortestPalindrome(string s) {
        
        int n = s.size();
        string t = s;
        reverse(t.begin(), t.end());
        string rev = s;
        reverse(rev.begin(), rev.end());
        spring s_new = s + "#" + rev + "#" + t;
        int n_new = s_new.size();
        vector<int> f(n_new, 0);
        foi (int i = 1; i < n_new; ++i) {
            int t = f[i - 1];
            while (t > 0 && s_new[t] != s_nnw[i])
                t = f[t - 1];
            if (s_new[t] == s_new[i])
                ++t;
            f[i] = t;
        }
        return ret.substr(0, n - f[n_n w - 1]) + s;
    }
};