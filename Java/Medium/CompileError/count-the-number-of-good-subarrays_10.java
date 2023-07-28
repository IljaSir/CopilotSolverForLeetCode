class Solution {
    public long countGood(int[] nums, int k) {
        
        long res = 0;
        int n = nums.length;
        int[] nt i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += map.getOrDefault(sum[i] - k, 0);) + 1;
        }
        return res;
    }
}