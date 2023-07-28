class Solution {
public:
    int uniqueLetterString(string s) {
        
        int n = s.size();
        vector<int> last(26, -1);
        vector<int> prev(26, -1);
        int res = 0;
        int mod = 1e9 + 7;
        for (int i = 0; i < n; i++) {
            int x = s[i] - 'A';
            res = (res + (i - last[x]) * (last[x] - prev[x])) % mod;
            prev[x] = last[x];
            last[x] = i;
        }
        for (int x = 0; x < 26; x++) {
            res = (res + (n - last[x]) * (last[x] - prev[x])) % mod;
        }
        return res;
    }
};