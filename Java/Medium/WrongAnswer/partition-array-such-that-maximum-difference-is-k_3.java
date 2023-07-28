class Solution {
    public int partitionArray(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(nums[i], min[i - 1]);
        }
        int[] max = new int[n];
        max[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(nums[i], max[i + 1]);
        }
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            if (max[i + 1] - min[i] > k) {
                ans++;
            }
        }
        return ans;
    }
}