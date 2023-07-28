class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        
        long l = 1, r = 2 * (long)1e9;
        while (l < r) {
            long mid = (l + r) / 2;
            long count = count(mid, a, b, c);
            if (count < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return (int)l;
    }
    
    private long count(long mid, int a, int b, int c) {
        long count = 0;
        count += mid / a + mid / b + mid / c;
        count -= mid / lcm(a, b) + mid / lcm(a, c) + mid / lcm(b, c);
        count += mid / lcm(a, lcm(b, c));
        return count;
    }
    
    private long gcd(long a, long b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}