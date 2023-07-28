class Solution {
public:
    int makeStringSorted(string s) {
        
        int mod = 1000000007;
        int n = s.size();
        vector<int> fact(n+1, 1);
        for(int i = 1; i <= n; i++) {
            fact[i] = (fact[i-1] * i) % mod;
        }
        vector<int> cnt(26);
        int ans = 0;
        for(int i = n-1; i >= 0; i--) {
            int c = s[i] - 'a';
            for(int j = 0; j < c; j++) {
                ans = (ans + cnt[j] * fact[n-i-1]) % mod;
            }
            cnt[c]++;
        }
        return ans;
    }
};