class Solution {
    public int minChanges(int[] nums, int k) {
        
        int n = nums.length;
        int[] f = new int[1 << 10];
        Arrays.fill(f, n);
        f[0] = 0;
        for (int i = 0; i < k; i++) {
            int cnt = 0;
            int[] g = new int[1 << 10];
            Arrays.fill(g, n);
            Map<Integer, Integer> cnts = new HashMap<>();
            for (int j = i; j < n; j += k) {
                cnts.put(nums[j], cnts.getOrDefault(nums[j], 0) + 1);
                cnt++;
            }
            int t2min = Math.min(f[0], cnt);
            for (int mask = 0; mask < (1 << 10); mask++) {
                g[mask] = Math.min(g[mask], t2min);
                for (Map.Entry<Integer, Integer> entry : cnts.entrySet()) {
                    int x = entry.getKey();
                    int c = entry.getValue();
                    g[mask] = Math.min(g[mask], f[mask ^ x] - c);
                }
            }
            f = g;
        }
        return f[0];
    }
}