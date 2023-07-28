class Solution {
    public long countGood(int[] nums, int k) {
        
        long res = 0;
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            res += cnt.getOrDefault(pre[i] - k, 0);
            cnt.put(pre[i], cnt.getOrDefault(pre[i], 0) + 1);
        }
        return res;
    }
}