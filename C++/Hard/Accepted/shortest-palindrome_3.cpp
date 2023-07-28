class Solution {
public:
    string shortestPalindrome(string s) {
        
        string rev = s;
        reverse(rev.begin(), rev.end());
        string l = s + "#" + rev;
        vector<int> f(l.size(), 0);
        for (int i = 1; i < l.size(); ++i) {
            int t = f[i - 1];
            while (t > 0 && l[t] != l[i]) t = f[t - 1];
            if (l[t] == l[i]) ++t;
            f[i] = t;
        }
        return rev.substr(0, s.size() - f.back()) + s;
    }
};