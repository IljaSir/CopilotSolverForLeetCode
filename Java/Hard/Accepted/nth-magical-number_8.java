class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        
        int c = gcd(a, b);
        long lcm = (long) a * b / c;
        long left = 0;
        long right = (long) Math.min(a, b) * n;
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = mid / a + mid / b - mid / lcm;
            if (count < n) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return (int) (ans % (1000000007));
    }
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}