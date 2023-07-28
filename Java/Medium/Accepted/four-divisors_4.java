class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int count = 0;
            int total = 0;
            for (int j = 1; j <= Math.sqrt(n); j++) {
                if (n % j == 0) {
                    count++;
                    total += j;
                    if (j != n / j) {
                        count++;
                        total += n / j;
                    }
                }
            }
            if (count == 4) {
                sum += total;
            }
        }
        return sum;
    }
}