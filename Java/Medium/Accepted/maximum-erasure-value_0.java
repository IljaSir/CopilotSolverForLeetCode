class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int result = 0;
        int left = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            while (set.contains(nums[i])) {
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[i]);
            result = Math.max(result, sum[i + 1] - sum[left]);
        }
        return result;
    }
}