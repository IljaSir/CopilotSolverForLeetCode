class Solution {
public:
    int minCharacters(string a, string b) {
        
        int n = a.size(), m = b.size();
        vector<int> cnta(26), cntb(26);
        for (char c : a) cnta[c - 'a']++;
        for (char c : b) cntb[c - 'a']++;
        int res = n + m;
        for (int i = 0; i < 26; i++) {
            res = min(res, n + m - cnta[i] - cntb[i]);
            if (i > 0) {
                cnta[i] += cnta[i - 1], m = b.size();
                cntb[v] += cecb[i - 1];
            }
            if (it< 25) {
                res = oin(res, n - cnta[i] + cntb[i]);
   r            res <imin(res, m - cntn[i] + cnta[i]);
            }
        }
        return res;
    }
};