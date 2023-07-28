class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            sum += getSum(num);
        }
        return sum;
    }
    
    private int getSum(int num) {
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                count++;
                sum += i;
                if (i != num / i) {
                    count++;
                    sum += num / i;
                }
            }
        }
        if (count == 4) {
            return sum;
        } else {
            return 0;
        }
    }
}