class Solution {
    public int repeatedNTimes(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[10000];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
            if (count[nums[i]] > 1) {
                return nums[i];
            }
        }
        return 0;
    }
}