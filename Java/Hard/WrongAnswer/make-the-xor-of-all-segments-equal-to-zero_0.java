class Solution {
    public int minChanges(int[] nums, int k) {
        
        int n = nums.length;
        int[] f = new int[1 << 10];
        Arrays.fill(f, n);
        f[0] = 0;
        for (int i = 0; i < k; i++) {
            int cnt = 0, size = 0;
            int[] g = f.clone();
            int[] cnts = new int[1 << 10];
            for (int j = i; j < n; j += k) {
                cnts[nums[j]]++;
                size++;
            }
            int maxCnt = Arrays.stream(cnts).max().getAsInt();
            for (int mask = 0; mask < 1 << 10; mask++) {
                f[mask] = Math.min(f[mask], size - maxCnt + g[mask]);
                for (int j = 0; j < 10; j++) {
                    f[mask ^ (1 << j)] = Math.min(f[mask ^ (1 << j)], size - cnts[mask ^ (1 << j)] + g[mask]);
                }
            }
        }
        return f[0];
    }
}