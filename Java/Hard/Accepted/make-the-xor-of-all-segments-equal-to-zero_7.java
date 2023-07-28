class Solution {
    public int minChanges(int[] nums, int k) {
        
        int n = nums.length;
        int[] f = new int[1 << 10];
        int INF = n + 1;
        Arrays.fill(f, INF);
        // 边界条件 f(-1,0)=0
        f[0] = 0;

        for (int i = 0; i < k; ++i) {
            // 第 i 个组的哈希映射
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            int size = 0;
            for (int j = i; j < n; j += k) {
                cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
                ++size;
            }

            // 求出 t2
            int t2min = Arrays.stream(f).min().getAsInt();

            int[] g = new int[1 << 10];
            Arrays.fill(g, t2min);
            for (int mask = 0; mask < (1 << 10); ++mask) {
                // t1 则需要枚举 x 才能求出
                for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                    int x = entry.getKey(), cntx = entry.getValue();
                    g[mask] = Math.min(g[mask], f[mask ^ x] - cntx);
                }
            }

            // 别忘了加上 size
            for (int j = 0; j < (1 << 10); ++j) {
                g[j] += size;
            }

            // 别忘了更新 f
            f = g;
        }

        return f[0];
    }
}