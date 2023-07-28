class Solution {
public:
    string findLexSmallestString(string s, int a, int b) {
        
        int n = s.size();
        string res = s;
        for (int i = 0; i < n; ++i) {
            string tmp = s;
            for (int j = 1; j < n; j += 2) {
                tmp[j] = (tmp[j] - '0' + a) % 10 + '0';
            }
            s = tmp.substr(n - b) + tmp.substr(0, n - b);
            res = min(res, min(s, tmp));
        }
        return res;
    }
};