class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        
        int n = nums.length;
        int m = quantity.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(map.get(key));
        }
        n = list.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }
        int[] dp = new int[1 << m];
        dp[0] = Integer.MAX_VALUE;
        for (int i = 0; i < 1 << m; i++) {
            if (dp[i] == 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                int mask = 0;
                for (int k = 0; k < m; k++) {
                    if (((i >> k) & 1) == 0 && arr[j] >= quantity[k]) {
                        mask |= 1 << k;
                    }
                }
                if (mask > 0) {
                    dp[i | mask] = Math.max(dp[i | mask], Math.min(dp[i], arr[j]));
                }
            }
        }
        return dp[(1 << m) - 1] > 0;
    }
}