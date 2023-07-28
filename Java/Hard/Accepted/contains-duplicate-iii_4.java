class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && ceiling <= nums[i] + valueDiff) {
                return true;
            }
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] <= floor + valueDiff) {
                return true;
            }
            set.add(nums[i]);
            if (i >= indexDiff) {
                set.remove(nums[i - indexDiff]);
            }
        }
        return false;
    }
}