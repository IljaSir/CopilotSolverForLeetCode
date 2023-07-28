class Solution {
public:
    string findLexSmallestString(string s, int a, int b) {
        
        string ans = s;
        int n = s.size();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j % 2 == 1) {
                    s[j] = (s[j] - '0' + a) % 10 + '0';
                }
            }
            ans = min(ans, s);
            s = s.substr(n - b) + s.substr(0, n - b);
        }
        return ans;
    }
};