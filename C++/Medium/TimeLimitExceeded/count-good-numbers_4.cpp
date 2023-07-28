class Solution {
public:
    int countGoodNumbers(long long n) {
        
        long long mod = 1e9 + 7;
        long long even = (n + 1) / 2;
        long long odd = n / 2;
        long long ans = 1;
        for (int i = 0; i < even; i++) {
            ans = (ans * 5) % mod;
        }
        for (int i = 0; i < odd; i++) {
            ans = (ans * 4) % mod;
        }
        return ans;
    }
};