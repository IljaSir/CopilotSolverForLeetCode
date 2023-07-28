class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        
        int lcm = a * b / gcd(a, b);
        long left = 0, right = (long) 1e15;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = mid / a + mid / b - mid / lcm;
            if (count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) (left % 1000000007);
    }
}