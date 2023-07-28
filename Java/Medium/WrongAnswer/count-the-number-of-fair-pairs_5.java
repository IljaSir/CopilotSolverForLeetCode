class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];
        TreeMap<Long, Integer> map = new TreeMap<>();
        for (int i = 0; i <= n; i++)
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            long lo = sum[i] + lower;
            long hi = sum[i] + upper;
            for (long key : map.subMap(lo, true, hi, true).keySet())
                ans += map.get(key);
            map.put(sum[i], map.get(sum[i]) - 1);
        }
        return ans;
    }
}