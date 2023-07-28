class Solution {
    public int minChanges(int[] nums, int k) {
        
        int n = nums.length;
        int[] f = new int[1024];
        int[] g = new int[1024];
        Arrays.fill(f, n);
        f[0] = 0;
        for (int i = 0; i < k; ++i) {
            int size = 0;
            int cnt = 0;
            Map<Integer, Integer> count = new HashMap<Integer, Integer>();
            for (int j = i; j < n; j += k) {
                count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
                size++;
            }
            int t2min = Arrays.stream(f).min().getAsInt();
            Arrays.fill(g, t2min);
            for (int mask = 0; mask < 1024; ++mask) {
                if (f[mask] == t2min) {
                    continue;
                }
                for (int x: count.keySet()) {
                    int y = mask ^ x;
                    g[y] = Math.min(g[y], f[mask] + size - count.get(x));
                }
            }
            int[] t = f;
            f = g;
            g = t;
        }
        return f[0];
    }
}