class Solution {
public:
    int uniqueLetterString(string s) {
        
        int n = s.size();
        int res = 0;
        vector<int> last(26, -1);
        vector<int> pre(26, -1);
        for (int i = 0; i < n; ++i) {
            int c = s[i] - 'A';
            res += (i - pre[c]) * (pre[c] - last[c]);
            last[c] = pre[c];
            pre[c] = i;
        }
        for (int i = 0; i < 26; ++i) {
            res += (n - pre[i]) * (pre[i] - last[i]);
        }
        return res;
    }
};