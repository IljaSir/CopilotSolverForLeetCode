class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            sum += getDivisorsSum(num);
        }
        return sum;
    }
    
    private int getDivisorsSum(int num) {
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    sum += i;
                    count++;
                } else {
                    sum += i;
                    sum += num / i;
                    count += 2;
                }
            }
        }
        return count == 4 ? sum : 0;
    }
}