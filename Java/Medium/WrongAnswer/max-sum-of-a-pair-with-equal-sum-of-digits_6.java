class Solution {
    public int maximumSum(int[] nums) {
        
        int[] sum = new int[100];
        int max = -1;
        for (int n : nums) {
            int s = sum(n);
            max = Math.max(max, sum[s] + n);
            sum[s] = Math.max(sum[s], n);
        }
        return max;
    }
    
    int sum(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }
}