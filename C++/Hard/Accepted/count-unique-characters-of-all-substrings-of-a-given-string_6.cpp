class Solution {
public:
    int uniqueLetterString(string s) {
        
        int n = s.size();
        vector<int> last(26, -1);
        vector<int> last2(26, -1);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int c = s[i] - 'A';
            ans += (i - last[c]) * (last[c] - last2[c]);
            last2[c] = last[c];
            last[c] = i;
        }
        for (int i = 0; i < 26; ++i) {
            ans += (n - last[i]) * (last[i] - last2[i]);
        }
        return ans;
    }
};