class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            int divisors = 0;
            for (int i = 1; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    divisors += 2;
                    if (i * i == num) {
                        divisors--;
                    }
                }
            }
            if (divisors == 4) {
                sum += num + 1;
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        sum += i;
                        if (i * i != num) {
                            sum += num / i;
                        }
                    }
                }
            }
        }
        return sum;
    }
}