class Solution {
    public int waysToPartition(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for (int i = 0; i < n; i++) {
            prefix[i] = nums[i] + (i > 0 ? prefix[i - 1] : 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = nums[i] + (i + 1 < n ? suffix[i + 1] : 0);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(suffix[i], map.getOrDefault(suffix[i], 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = prefix[i];
            int right = suffix[i + 1];
            map.put(suffix[i + 1], map.get(suffix[i + 1]) - 1);
            if (left == right) {
                res = Math.max(res, map.get(right));
            }
            res = Math.max(res, map.getOrDefault(left, 0));
        }
        return res;
    }
}