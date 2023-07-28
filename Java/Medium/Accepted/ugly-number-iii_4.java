class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        
        long min = 1;
        long max = Integer.MAX_VALUE;
        while (min < max) {
            long mid = min + (max - min) / 2;
            if (count(mid, a, b, c) < n) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return (int) min;
    }
    
    private long count(long mid, int a, int b, int c) {
        return mid / a + mid / b + mid / c - mid / lcm(a, b) - mid / lcm(b, c) - mid / lcm(a, c) + mid / lcm(a, lcm(b, c));
    }
    
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
    
    private long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}