class Solution {
public:
    int numberOfWays(string corridor) {
        
        int n = corridor.size();
        int mod = 1e9 + 7;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (corridor[i] == 'S') cnt++;
        }
        if (cnt % 2 == 1) return 0;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (corridor[i] == 'S') {
                int j = i;
                while (j < n && corridor[j] == 'S') j++;
                int k = j - i;
                if (i == 0 || j == n) {
                    ans = (long long)ans * (k + 1) % mod;
                } else {
                    ans = (long long)ans * k % mod;
                }
                i = j - 1;
            }
        }
        return ans;
    }
};