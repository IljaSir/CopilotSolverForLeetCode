class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int max = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        Set<Integer> set = new HashSet<>();
        while (end < nums.length) {
            if (set.contains(nums[end])) {
                max = Math.max(max, sum);
                while (nums[start] != nums[end]) {
                    set.remove(nums[start]);
                    sum -= nums[start];
                    start++;
                }
                start++;
            } else {
                set.add(nums[end]);
                sum += nums[end];
            }
            end++;
        }
        return Math.max(max, sum);
    }
}