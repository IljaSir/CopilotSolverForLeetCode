class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            if ((set.floor(n) != null && n <= set.floor(n) + valueDiff)
                    || (set.ceiling(n) != null && set.ceiling(n) <= n + valueDiff)) {
                return true;
            }
            set.add(n);
            if (i >= indexDiff) {
                set.remove(nums[i - indexDiff]);
            }
        }
        return false;
    }
}