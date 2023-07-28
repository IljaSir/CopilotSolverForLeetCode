class Solution {
    public int partitionArray(int[] nums, int k) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && nums[j] - nums[i] <= k) {
                j++;
            }
            ans++;
            i = j;
        }
        return ans;
    }
}