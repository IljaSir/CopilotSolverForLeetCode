class Solution {
    public int minChanges(int[] nums, int k) {
        
        int n = nums.length;
        int[] f = new int[1 << 10];
        int[] g = new int[1 << 10];
        Arrays.fill(f, n);
        f[0] = 0;
        for (int i = 0; i < k; i++) {
            int size = 0;
            int mask = 0;
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int j = i; j < n; j += k) {
                cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
                size++;
            }
            int t2min = Arrays.stream(f).min().getAsInt();
            Arrays.fill(g, t2min);
            for (int mask2 = 0; mask2 < 1 << 10; mask2++) {
                for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                    int x = entry.getKey(), countX = entry.getValue();
                    g[mask2] = Math.min(g[mask2], f[mask2 ^ x] - countX);
                }
            }
            int t1min = Arrays.stream(g).min().getAsInt();
            for (int mask2 = 0; mask2 < 1 << 10; mask2++) {
                g[mask2] += size;
            }
            int[] temp = f;
            f = g;
            g = temp;
        }
        return f[0];
    }
}