class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        long sum = 0;
        long m = n;
        while (m > 0) {
            sum += m % 10;
            m /= 10;
        }
        long ans = 0;
        while (sum > target) {
            ans += Math.pow(10, sum - target);
            sum = target;
        }
        return ans;
    }
}