class Solution {
public:
    int countAnagrams(string s) {
        
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == ' ') {
                cnt++;
            }
        }
        int ans = 1;
        int mod = 1e9 + 7;
        for (int i = 0; i < cnt; i++) {
            ans = ans * (i + 1) % mod;
        }
        return ans;
    }
};