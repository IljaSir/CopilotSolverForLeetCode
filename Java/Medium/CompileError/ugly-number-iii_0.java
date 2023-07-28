class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        
        long left = 1;
        long right = 2 * (long) Math.pow(10, 9);
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (check(mid, a, b, c) >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private long check(long mid, long a, long b, long c) {
        long lcm_ab = a * b / gcd(a, b);
        long lcm_bc = b * c / gcd(b, c);
        long lcm_ac = a * c / gcd(a, c);
        long lcm_abc = lcm_ab * c / gcd(lcm_ab, c);
        return mid / a + mid / b + mid / c - mid / lcm_ab - mid / lcm_bc - mid / lcm_ac + mid / lcm_abc;
    }
}