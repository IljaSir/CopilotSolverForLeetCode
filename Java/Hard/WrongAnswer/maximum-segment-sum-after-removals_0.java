class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        
        int n = nums.length;
        long[] ans = new long[n];
        long[] presum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
        List<Integer>[] pos = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            pos[removeQueries[i]].add(i);
        }
        TreeSet<Integer> set = new TreeSet<>();
        set.add(-1);
        set.add(n);
        for (int i = n - 1; i >= 0; i--) {
            for (int j : pos[i]) {
                set.add(j);
            }
            Integer l = set.lower(i);
            Integer r = set.higher(i);
            ans[i] = presum[r] - presum[l + 1];
        }
        return ans;
    }
}