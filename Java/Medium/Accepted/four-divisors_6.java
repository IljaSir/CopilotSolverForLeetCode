class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            int count = 0;
            int sumDivisor = 0;
            for (int i = 1; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    sumDivisor += i;
                    count++;
                    if (i != num / i) {
                        sumDivisor += num / i;
                        count++;
                    }
                }
            }
            if (count == 4) {
                sum += sumDivisor;
            }
        }
        return sum;
    }
}