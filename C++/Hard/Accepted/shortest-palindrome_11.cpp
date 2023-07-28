class Solution {
public:
    string shortestPalindrome(string s) {
        
        string rev = s;
        reverse(rev.begin(), rev.end());
        string s_new = s + "#" + rev;
        vector<int> f(s_new.size());
        for (int i = 1; i < s_new.size(); ++i) {
            int t = f[i - 1];
            while (t > 0 && s_new[i] != s_new[t])
                t = f[t - 1];
            if (s_new[i] == s_new[t]) ++t;
            f[i] = t;
        }
        return rev.substr(0, s.size() - f.back()) + s;
    }
};