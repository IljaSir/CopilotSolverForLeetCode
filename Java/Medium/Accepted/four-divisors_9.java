class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            if (num == 1) continue;
            int divisors = 0;
            int divisor = 1;
            int total = 0;
            while (divisor * divisor <= num) {
                if (num % divisor == 0) {
                    divisors++;
                    total += divisor;
                    if (divisor * divisor != num) {
                        divisors++;
                        total += num / divisor;
                    }
                }
                divisor++;
            }
            if (divisors == 4) {
                sum += total;
            }
        }
        return sum;
    }
}