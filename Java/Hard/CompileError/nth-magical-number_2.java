class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        
        int mod = 1000000007;
        long lcm = a / gcd(a, b) * b;
        long low = Math.min(a, b);
        long high = (long) n * low;
        while (low < high) {
            long mid = (low + high) / 2;
            long count = mid / a + mid / b - mid / lcm;
            if (count < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (int) (low % mod);
    }
}