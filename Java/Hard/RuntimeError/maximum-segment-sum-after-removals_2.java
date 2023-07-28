class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        
        int n = nums.length;
        long[] ans = new long[n];
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        TreeSet<Integer> set = new TreeSet<>();
        set.add(-1);
        set.add(n);
        for (int i = n - 1; i >= 0; i--) {
            int x = removeQueries[i];
            set.add(x);
            Integer l = set.lower(x);
            Integer r = set.higher(x);
            ans[i] = Math.max(ans[i], prefix[r] - prefix[x + 1]);
            ans[i] = Math.max(ans[i], prefix[x] - prefix[l + 1]);
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        return ans;
    }
}