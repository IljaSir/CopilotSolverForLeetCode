class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        
        if (nums.length < 2) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long)nums[i] - (long)valueDiff);
            if (ceiling != null && ceiling <= (long)nums[i] + (long)valueDiff) {
                return true;
            }
            set.add((long)nums[i]);
            if (set.size() > indexDiff) {
                set.remove((long)nums[i - indexDiff]);
            }
        }
        return false;
    }
}