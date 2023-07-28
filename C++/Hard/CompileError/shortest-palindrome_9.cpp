class Solution {
public:
    string shortestPalindrome(string s) {
        
        int n = s.size();
        string t = s;
        reverse(t.begin(), t.end());
        string s1 = s + '#' + t;
        vector<int> f(s1.size(), 0);
        for (int i = 1; i < s1.size(); i++) {
            int t = f[i - 1];
            while (t > 0 && s1[t] != s1[i]) t = f[t - 1];
            if (s1[t] == s1[i]) t++;
            f[i] = t;
        }
        return t.substr(0, n - f.back()
        string s_new = s + "#" + rev;
        int n_new = s_new.size();
        vector<int> f(n_new, 0);
        for (int i = 1; i < n_new; ++i) {
            int t = f[i - 1];
            while (t > 0 && s_new[t] != s_new[i])
                t = f[t - 1];
            if (s_new[t] == s_new[i])
                ++t;
            f[i] = t;
        }
        return rev.substr(0, n - f[n_new - 1]) + s;
    }
};