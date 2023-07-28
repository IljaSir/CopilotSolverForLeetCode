class Solution {
    public int minChanges(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] f = new int[1024];
        Arrays.fill(f, n);
        f[0] = 0;
        for (int i = 0; i < k; ++i) {
            int size = 0;
            int mask = 0;
            map.clear();
            for (int j = i; j < n; j += k) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                ++size;
            }
            int t2min = Math.min(f[i], size);
            int[] g = new int[1024];
            Arrays.fill(g, t2min);
            for (int mask2 = 0; mask2 < 1024; ++mask2) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int x = entry.getKey();
                    int cnt = entry.getValue();
                    g[mask2] = Math.min(g[mask2], f[i] - cnt + g[mask2 ^ x]);
                }
            }
            f = g;
        }
        return f[0];
    }
}