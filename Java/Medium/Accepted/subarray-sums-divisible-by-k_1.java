class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int s : sum) {
            int mod = s % k;
            if (mod < 0) {
                mod += k;
            }
            ans += map.getOrDefault(mod, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }
}