class Solution {
    public int countGoodNumbers(long n) {
        
        long ans = 1;
        long MOD = 1000000007;
        long even = n / 2;
        long odd = n - even;
        ans = (ans * pow(5, even, MOD)) % MOD;
        ans = (ans * pow(4, odd, MOD)) % MOD;
        return (int)ans;
    }
}