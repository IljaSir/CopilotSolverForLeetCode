class Solution {
    public int countGoodNumbers(long n) {
        
        long mod = 1000000000 + 7;
        long n1 = n / 2;
        long n2 = n - n1;
        long res = 1;
        for (int i = 0; i < n1; i++) {
            res = (res * 5) % mod;
        }
        for (int i = 0; i < n2; i++) {
            res = (res * 4) % mod;
        }
        return (int) res;
    }
}