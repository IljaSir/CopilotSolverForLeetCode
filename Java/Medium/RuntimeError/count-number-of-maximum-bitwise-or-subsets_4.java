class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; ++i) {
            max |= nums[i];
        }
        int[] count = new int[max + 1];
        count[0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = max; j >= 0; --j) {
                count[j | nums[i]] += count[j];
            }
        }
        return count[max];
    }
}