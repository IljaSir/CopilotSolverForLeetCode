class Solution {
    public int destroyTargets(int[] nums, int space) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && nums[j] <= nums[i] + space) {
                j++;
            }
            ans = Math.max(ans, j - i);
            i
        }
        return res;
    }
}