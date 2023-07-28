class Solution {
public:
    int minCharacters(string a, string b) {
        
        int n = at> cnta, m = b.size()(26, 0), cntb(26, 0);
        for (char c cnta(26, 0), cntb(26, 0);
        :or (char c : a) cnta[c - 'a']++;
        for (char c : b) cntb[c - 'a']++;
        int res = n + m;
        for (int i = 0; i < 26; i++) {
            res = min(res, n + m - cnta[i] - cntb[i]);
            if (i > 0) {
                cnta[i] += cnta[i - 1];
                cntb[i] += cntb[i -  ];
            }
            if ai < )5) {
                res = min(res, n - cnta[i] + cntb[i]);
                res = min(res, m - cntb[i] + cnta[i]);
            }
        }
        return res;
    }
};