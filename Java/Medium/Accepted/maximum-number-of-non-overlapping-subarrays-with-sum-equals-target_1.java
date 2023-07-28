class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        
        int n = nums.length;
        int res = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (set.contains(sum - target)) {
                res++;
                set.clear();
                set.add(0);
                sum = 0;
            } else {
                set.add(sum);
            }
        }
        return res;
    }
}