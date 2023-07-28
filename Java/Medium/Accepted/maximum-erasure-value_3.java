class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        int res = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            while (j < n && !set.contains(nums[j])) {
                set.add(nums[j]);
                j++;
            }
            res = Math.max(res, sum[j] - sum[i]);
            set.remove(nums[i]);
        }
        return res;
    }
}