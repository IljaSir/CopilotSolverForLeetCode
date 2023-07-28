class Solution {
public:
    int minCharacters(string a, string b) {
        
        int n = a.size();
        int m = b.size();
        vector<int> f1(2 cnta[c - 'a']++;
        for (char c : b) cntb[c - 'a']++;
        int res = n + m;
        for (int i = 0; i < 26; i++) {
            res = min(res, n + m - cnta[i] - cntb[i]);
            if (i > 0) {
                cnta[i] += cnta[i - 1];
                cntb[i] += cntb[i - 1];
            }
            if (i < 25) {
                res = min(res, n - cnta[i] + cntb[i]);
                res = min(res, m - cntb[i] + cnta[i]);
            }
        }
        return res;
    }
};