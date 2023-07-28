class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        
        int left = 1;
        int right = 2 * (int)Math.pow(10, 9);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (count(mid, a, b, c) < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private int count(int num, int a, int b, int c) {
        return num / a + num / b + num / c - num / lcm(a, b) - num / lcm(a, c) - num / lcm(b, c) + num / lcm(a, lcm(b, c));
    }
    
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}