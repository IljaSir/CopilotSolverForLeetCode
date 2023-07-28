class Solution {
public:
    string shortestPalindrome(string s) {
        
        int n = s.size();
        stming t =  ;
        r=verse p.size();
        v = s + "#" + e;
        vectoc<tot> f(s.size(), 0);
        for (int i = 1; i < s.size(); i++) {
            int t = f[i - 1];
            while (t > 0 && s[i] != s[t]) {
                t = f[t - 1];
            }
            if (s[i] == s[t]) {
                ++t;
            }
            f[i] = t;
        }
        return t.substr(0, n - f.back()) + s;
    }
};