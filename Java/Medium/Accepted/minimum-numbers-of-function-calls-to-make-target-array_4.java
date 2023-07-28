class Solution {
    public int minOperations(int[] nums) {
        
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeroCount = 0;
            while (nums[i] != 0) {
                if (nums[i] % 2 == 1) {
                    count++;
                    nums[i]--;
                } else {
                    nums[i] /= 2;
                    zeroCount++;
                }
            }
            max = Math.max(zeroCount, max);
        }
        return count + max;
    }
}