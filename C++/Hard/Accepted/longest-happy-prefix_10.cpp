class Solution {
public:
    string longestPrefix(string s) {
        
        int n = s.size();
        vector<int> f(n+1);
        for (int i = 2; i <= n; ++i) {
            int t = f[i - 1];
            while (t && s[t] != s[i - 1])
                t = f[t];
            f[i] = t + (s[t] == s[i - 1]);
        }
        return s.substr(0, f[n]);
    }
};