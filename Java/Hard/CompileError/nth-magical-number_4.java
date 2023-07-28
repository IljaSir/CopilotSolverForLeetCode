class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        
        int mod = 1_000_000_007;
        int lcm = a / gcd(a, b) * b;
        int low = Math.min(a, b);
        int high = (int)1e15;
        while (low < high) {
            int mid = low + high >> 1;
            if (mid / a + mid / b - mid / lcm < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (int)(low % mod);
    }
}