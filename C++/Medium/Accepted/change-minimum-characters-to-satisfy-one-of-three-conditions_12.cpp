class Solution {
public:
    int minCharacters(string a, string b) {
        
        int n = a.size();
        int m = b.size();
        int ans = n + m;
        vector<int> cnta(26, 0), cntb(26, 0);
        for (char c : a) cnta[c - 'a']++;
        for (char c : b) cntb[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            ans = min(ans, n + m - cnta[i] - cntb[i]);
            if (i > 0) {
                cnta[i] += cnta[i - 1];
                cntb[i] += cntb[i - 1];
            }
            if (i < 25) {
                ans = min(ans, n - cnta[i] + cntb[i]);
                ans = min(ans, m - cntb[i] + cnta[i]);
            }
        }
        return ans;
    }
};