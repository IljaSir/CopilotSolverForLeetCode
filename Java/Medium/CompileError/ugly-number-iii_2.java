class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        
        int l = 0, r = Integer.MAX_VALUE;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (count(m, a, b, c) < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private int count(int m, int a, int b, int c) {
        return m / a + m / b + m / c - m / lcm(a, b) - m / lcm(a, c) - m / lcm(b, c) + m / lcm(a, lcm(b, c));
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}