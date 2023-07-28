class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int i = 0, j = 0, sum = 0, max = 0;
        Set<Integer> set = new HashSet<>();
        while (j < nums.length) {
            if (!set.contains(nums[j])) {
                set.add(nums[j]);
                sum += nums[j];
                j++;
                max = Math.max(max, sum);
            } else {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
        }
        return max;
    }
}