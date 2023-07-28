class Solution {
    public int minNonZeroProduct(int p) {
        
        long mod = 1000000007;
        long max = (long) Math.pow(2, p) - 1;
        long min = max / 2;
        long result = (max - 1) % mod;
        long pow = (long) Math.pow(2, p - 1) % mod;
        result = result * pow % mod;
        return (int) result;
    }
}