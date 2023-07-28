class Solution {
public:
    int uniqueLetterString(string s) {
        
        int n = s.size();
        vector<int> last(26, -1);
        vector<int> next(n, -1);
        for (int i = n - 1; i >= 0; --i) {
            int c = s[i] - 'A';
            next[i] = last[c];
            last[c] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int c = s[i] - 'A';
            int j = last[c];
            if (j == -1) {
                ans += (i + 1) * (n - i);
            } else {
                ans += (i - j) * (j - next[j]);
            }
            last[c] = next[i];
        }
        return ans;
    }
};