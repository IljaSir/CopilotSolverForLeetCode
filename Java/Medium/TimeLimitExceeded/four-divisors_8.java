class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int count = 0;
        for (int num : nums) {
            int temp = 0;
            int sum = 0;
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    temp++;
                    sum += i;
                }
            }
            if (temp == 4) {
                count += sum;
            }
        }
        return count;
    }
}