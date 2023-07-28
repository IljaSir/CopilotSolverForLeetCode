class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        int count = 0;
        for (int i = 0; i < 1 << n; i++) {
            int or = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    or |= nums[j];
                }
            }
            if (or > max) {
                max = or;
                count = 1;
            } else if (or == max) {
                count++;
            }
        }
        return count;
    }
}