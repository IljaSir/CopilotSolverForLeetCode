class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        
        int n = nums.length;
        long[] ans = new long[n];
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int[] next = new int[n];
        Arrays.fill(next, n);
        boolean[] removed = new boolean[n];
        for (int i = 0; i < n; i++) {
            int index = removeQueries[i];
            removed[index] = true;
            if (index > 0 && !removed[index - 1]) {
                next[index - 1] = index;
            }
            if (index < n - 1 && !removed[index + 1]) {
                next[index] = index + 1;
            }
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                set.add(i);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int index = removeQueries[i];
            if (set.isEmpty()) {
                ans[i] = 0;
            } else {
                int left = set.floor(index);
                int right = next[left];
                ans[i] = prefix[right] - prefix[left];
            }
            set.remove(index);
        }
        return ans;
    }
}