class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            int divisors = 0;
            int sumDivisors = 0;
            for (int i = 1; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    divisors += 2;
                    sumDivisors += i;
                    if (i * i != num) {
                        sumDivisors += num / i;
                    }
                }
            }
            if (divisors == 4) {
                sum += sumDivisors;
            }
        }
        return sum;
    }
}