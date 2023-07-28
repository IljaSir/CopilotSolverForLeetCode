class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int mod = (sum[i] % k + k) % k;
            int cnt = map.getOrDefault(mod, 0);
            ans += cnt;
            map.put(mod, cnt + 1);
        }
        return ans;
    }
}