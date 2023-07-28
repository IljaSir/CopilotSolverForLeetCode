class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int result = 0;
        for (int i : nums) {
            result += getSumOfDivisors(i);
        }
        return result;
    }
    
    private int getSumOfDivisors(int num) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
                sum += i;
            }
        }
        return count == 4 ? sum : 0;
    }
}