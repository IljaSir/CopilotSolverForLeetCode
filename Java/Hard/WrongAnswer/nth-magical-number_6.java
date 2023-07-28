class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        
        int mod = 1000000007;
        int lcm = a * b / gcd(a, b);
        int left = 1;
        int right = 1000000000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = mid / a + mid / b - mid / lcm;
            if (count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) (left % mod);
    }
    private int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}