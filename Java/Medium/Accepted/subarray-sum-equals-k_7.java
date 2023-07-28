class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n+1];
        sum[0] = 0;
        for (int i=0; i<n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i=0; i<=n; i++) {
            int target = sum[i] - k;
            if (map.containsKey(target)) {
                res += map.get(target);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        
        return res;
    }
}