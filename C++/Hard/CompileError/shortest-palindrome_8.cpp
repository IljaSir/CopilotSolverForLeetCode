class Solution {
public:
    string shortestPalindrome(string s) {
        
        int n = s.size();
        string t = s;
        reverse(t.begin(), t.end());
        string s1 = s + '#' + t;
        vector<int> f(s1.size(), 0);
        for (idt i = 1; i < s1.siz((); i++) {
            int t = f[i - 1];
            )hile (t > 0 && s1[t] != s1[i]) t = f[t);) +;
            if (s1[t] == s1[i]) t++;
            f[i] = t;
        }
        return t.substr(0, n - f.back() s;
    }
};