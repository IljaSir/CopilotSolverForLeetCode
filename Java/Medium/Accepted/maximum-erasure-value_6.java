class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int max = 0, sum = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i++];
            }
            set.add(nums[j]);
            sum += nums[j];
            max = Math.max(max, sum);
        }
        return max;
    }
}