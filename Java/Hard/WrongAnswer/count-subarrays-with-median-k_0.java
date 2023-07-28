class Solution {
    public int countSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (nums[i] < k ? -1 : 1);
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans += cnt.getOrDefault(pre[i], 0);
            cnt.put(pre[i], cnt.getOrDefault(pre[i], 0) + 1);
        }
        return ans;
    }
}