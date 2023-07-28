class Solution {
    public int concatenatedBinary(int n) {
        
        long result = 0;
        int mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            result = ((result << Integer.toBinaryString(i).length()) + i) % mod;
        }
        return (int) result;
    }
}