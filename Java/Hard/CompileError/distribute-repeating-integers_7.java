class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        
        int n = nums.length, m = quantity.length;
        int[] cnt = new int[101];
        for (int num : nums) cnt[num]++;
        int[] q = new int[m];
        for (int i = 0; i < m; i++) q[i] = quantity[i];
        Arrays.sort(q);
        return dfs(cnt, q, 100);
    }
    private boolean dfs(int[] cnt, int[] q, int max) {
        while (max > 0 && cnt[max] == 0) max--;
        if (max == 0) return true;
        for (int i = 0; i < q.length; i++) {
            if (q[i] <= cnt[max]) {
                q[i] = 0;
                if (dfs(cnt, q, max)) return true;
                q[i] = quantity[i];
            }
        }
        return false;
    }
}