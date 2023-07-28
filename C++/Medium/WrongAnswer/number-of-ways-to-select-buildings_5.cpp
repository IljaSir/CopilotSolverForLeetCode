class Solution {
public:
    long long numberOfWays(string s) {
        
        long long mod = 1e9 + 7;
        long long n = s.size();
        long long count = 0;
        for(int i = 0; i < n; i++) {
            if(s[i] == '1') count++;
        }
        if(count % 3 != 0) return 0;
        if(count == 0) {
            long long res = (n - 1) * (n - 2) / 2;
            return res % mod;
        }
        long long k = count / 3;
        long long i = 0, j = 0;
        long long cnt = 0;
        while(i < n) {
            if(s[i] == '1') cnt++;
            if(cnt == k) break;
            i++;
        }
        long long left = i + 1;
        while(i < n) {
            if(s[i] == '1') cnt++;
            if(cnt == 2 * k) break;
            i++;
        }
        long long right = i - left + 1;
        while(i < n) {
            if(s[i] == '1') cnt++;
            if(cnt == 3 * k) break;
            i++;
        }
        long long mid = i - left - right + 1;
        long long res = left * mid * right;
        return res % mod;
    }
};