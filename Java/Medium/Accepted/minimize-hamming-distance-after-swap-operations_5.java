class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int n = source.length;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int[] swap : allowedSwaps) {
            union(f, swap[0], swap[1]);
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = find(f, i);
            map.computeIfAbsent(x, z -> new HashMap<>()).merge(source[i], 1, Integer::sum);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = find(f, i);
            Map<Integer, Integer> cnt = map.get(x);
            int y = target[i];
            if (cnt.getOrDefault(y, 0) == 0) {
                ans++;
            } else {
                cnt.put(y, cnt.get(y) - 1);
            }
        }
        return ans;
    }

    public void union(int[] f, int x, int y) {
        int fx = find(f, x), fy = find(f, y);
        if (fx != fy) {
            f[fx] = fy;
        }
    }

    public int find(int[] f, int x) {
        if (f[x] == x) {
            return x;
        }
        int newf = find(f, f[x]);
        f[x] = newf;
        return newf;
    }
}