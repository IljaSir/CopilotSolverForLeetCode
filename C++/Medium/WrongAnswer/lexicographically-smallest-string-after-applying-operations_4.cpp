class Solution {
public:
    string findLexSmallestString(string s, int a, int b) {
        
        int n = s.size();
        string res = s;
        for (int i = 0; i < n; i++) {
            string t = s;
            for (int j = 0; j < n; j++) {
                if (j & 1) {
                    t[j] = (t[j] - '0' + a) % 10 + '0';
                }
            }
            res = min(res, t);
            s = s.substr(n - b) + s.substr(0, n - b);
        }
        return res;
    }
};