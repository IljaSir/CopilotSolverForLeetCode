class Solution {
    public int repeatedNTimes(int[] nums) {
        
        int n = nums.length / 2;
        int[] count = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            if (count[nums[i]] == n) {
                return nums[i];
            }
        }
        return 0;
    }
}