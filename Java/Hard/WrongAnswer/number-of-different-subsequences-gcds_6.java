class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] cnt = new int[max + 1];
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        boolean[] vis = new boolean[max + 1];
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            if (cnt[i] > 0) {
                ans++;
            }
            if (cnt[i] == 0) {
                continue;
            }
            for (int j = 2 * i; j <= max; j += i) {
                if (vis[j]) {
                    continue;
                }
                if (cnt[j] > 0) {
                    ans++;
                    vis[j] = true;
                }
            }
        }
        return ans;
    }
}