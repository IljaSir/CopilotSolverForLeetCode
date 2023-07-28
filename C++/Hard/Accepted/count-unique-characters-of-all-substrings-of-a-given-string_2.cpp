class Solution {
public:
    int uniqueLetterString(string s) {
        
        int res = 0, mod = 1e9 + 7, n = s.size();
        vector<int> last(26, -1), pre(26, -1);
        for (int i = 0; i < n; ++i) {
            int c = s[i] - 'A';
            res = (res + (i - last[c]) * (last[c] - pre[c])) % mod;
            pre[c] = last[c];
            last[c] = i;
        }
        for (int i = 0; i < 26; ++i) {
            res = (res + (n - last[i]) * (last[i] - pre[i])) % mod;
        }
        return res;
    }
};