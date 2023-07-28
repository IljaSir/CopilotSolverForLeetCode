class Solution {
    public int minOperations(int[] nums) {
        
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            int tmp = 0;
            while (num > 0) {
                if (num % 2 == 1) {
                    sum++;
                }
                num /= 2;
                tmp++;
            }
            max = Math.max(max, tmp);
        }
        return max + sum - 1;
    }
}