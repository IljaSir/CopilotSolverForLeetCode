class Solution {
    public int repeatedNTimes(int[] nums) {
        
        int len = nums.length;
        int[] count = new int[10001];
        for (int i = 0; i < len; i++) {
            count[nums[i]]++;
            if (count[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }
}