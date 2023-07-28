class Solution {
public:
    int countAnagrams(string s) {
        
        int n = s.size();
        int res = 0;
        int mod = 1e9 + 7;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && s[j] != ' ') {
                j++;
            }
            int cnt = j - i;
            res = (res + (long long)cnt * (cnt + 1) / 2) % mod;
            i = j;
        }
        return res;
    }
};