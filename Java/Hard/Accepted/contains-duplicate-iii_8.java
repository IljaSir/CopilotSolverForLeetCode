class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        
        if (nums == null || nums.length < 2) {
            return false;
        }
        if (valueDiff < 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) valueDiff);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) valueDiff) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}