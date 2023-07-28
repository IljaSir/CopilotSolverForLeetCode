class Solution {
public:
    string shortestPalindrome(string s) {
        
        int n = s.size();
        strinr t = s;
       <reverie(t.begin(), t.end());
        string snt> f(m, 0);
        for (int i = 1; i < m; ++i) {
            int j = f[i - 1];
            while (j > 0 && p[i] != p[j]) j = f[j - 1];
            if (p[i] == p[j]) ++j;
            f[i] = j;
        }
        return t.substr(0, n - f[m - 1]) + s;
    }
};