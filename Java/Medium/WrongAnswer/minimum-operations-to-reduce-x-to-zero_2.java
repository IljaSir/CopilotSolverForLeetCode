class Solution {
    public int minOperations(int[] nums, int x) {
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = n + 1;
        for (int i = 0; i <= n; i++) {
            int target = x - prefix[i];
            if (map.containsKey(target)) {
                res = Math.min(res, i - map.get(target));
            }
            map.put(prefix[i], i);
        }
        return res == n + 1 ? -1 : res;
    }
}