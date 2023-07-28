class Solution {
public:
    int uniqueLetterString(string s) {
        
        int n = s.size();
        int ans = 0;
        vector<int> last(26, -1);
        vector<int> pre(26, -1);
        for (int i = 0; i < n; i++) {
            int c = s[i] - 'A';
            ans += (i - last[c]) * (last[c] - pre[c]);
            pre[c] = last[c];
            last[c] = i;
        }
        for (int c = 0; c < 26; c++) {
            ans += (n - last[c]) * (last[c] - pre[c]);
        }
        return ans;
    }
};