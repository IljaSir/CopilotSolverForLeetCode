class Solution {
public:
    int countAnagrams(string s) {
        
        int n = s.size();
        int ans = 0;
        int mod = 1e9 + 7;
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            int j = i;
            while (j < n && s[j] != ' ') {
                ++cnt;
                ++j;
            }
            ans = (ans + (cnt * (cnt - 1) / 2) % mod) % mod;
            i = j;
        }
        return ans;
    }
};