class Solution {
public:
    int countHomogenous(string s) {
        
        int n = s.size();
        int i = 0;
        int j = 0;
        int res = 0;
        int mod = 1e9 + 7;
        while (i < n) {
            while (j < n && s[j] == s[i]) {
                j++;
            }
            int len = j - i;
            res = (res + (len * (len + 1) / 2) % mod) % mod;
            i = j;
        }
        return res;
    }
};