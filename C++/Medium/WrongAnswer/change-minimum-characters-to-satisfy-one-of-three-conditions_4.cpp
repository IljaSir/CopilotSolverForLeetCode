class Solution {
public:
    int minCharacters(string a, string b) {
        
        int cnta[26] = {0}, cntb[26] = {0};
        for (char c : a) ++cnta[c - 'a'];
        for (char c : b) ++cntb[c - 'a'];
        int n = a.size(), m = b.size();
        int res = n + m;
        for (int i = 0; i < 25; ++i) {
            res = min(res, n + m - cnta[i] - cntb[i]);
            res = min(res, n - cnta[i] + cntb[i]);
            res = min(res, m - cntb[i] + cnta[i]);
        }
        return res;
    }
};