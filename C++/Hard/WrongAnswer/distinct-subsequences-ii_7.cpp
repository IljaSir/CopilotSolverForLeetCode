class Solution {
public:
    int distinctSubseqII(string s) {
        
        const int MOD = 1e9 + 7;
        int n = s.size();
        vector<int> sum(n + 1, 0);
        vector<int> last(26, -1);
        for (int i = 0; i < n; i++) {
            int x = s[i] - 'a';
            sum[i + 1] = sum[i] * 2 % MOD;
            if (last[x] >= 0) {
                sum[i + 1] -= sum[last[x]];
                sum[i + 1] %= MOD;
            }
            sum[i + 1] += 2;
            sum[i + 1] %= MOD;
            last[x] = i;
        }
        sum[n]--;
        if (sum[n] < 0) sum[n] += MOD;
        return sum[n];
    }
};