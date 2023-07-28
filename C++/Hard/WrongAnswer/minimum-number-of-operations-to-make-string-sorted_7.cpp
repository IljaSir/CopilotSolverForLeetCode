class Solution {
public:
    int makeStringSorted(string s) {
        
        int n = s.size();
        vector<int> f(26, 0);
        for (auto c : s) {
            f[c - 'a']++;
        }
        long long ans = 0;
        long long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = (fact * i) % 1000000007;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s[i] - 'a'; j++) {
                if (f[j] > 0) {
                    f[j]--;
                    long long tmp = fact;
                    for (int k = 0; k < 26; k++) {
                        for (int l = 1; l <= f[k]; l++) {
                            tmp = (tmp * modInv(l)) % 1000000007;
                        }
                    }
                    ans = (ans + tmp) % 1000000007;
                    f[j]++;
                }
            }
            f[s[i] - 'a']--;
            fact = (fact * modInv(n - i)) % 1000000007;
        }
        return ans;
    }
    
    long long modInv(long long x) {
        return powMod(x, 1000000007 - 2);
    }
    
    long long powMod(long long x, long long y) {
        long long ans = 1;
        while (y > 0) {
            if (y & 1) {
                ans = (ans * x) % 1000000007;
            }
            y >>= 1;
            x = (x * x) % 1000000007;
        }
        return ans;
    }
};