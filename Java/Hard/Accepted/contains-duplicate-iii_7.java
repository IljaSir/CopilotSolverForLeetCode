class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long min = num - valueDiff;
            long max = num + valueDiff;
            Long lower = set.ceiling(min);
            Long upper = set.floor(max);
            if (lower != null && lower <= max) {
                return true;
            }
            if (upper != null && upper >= min) {
                return true;
            }
            set.add(num);
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}