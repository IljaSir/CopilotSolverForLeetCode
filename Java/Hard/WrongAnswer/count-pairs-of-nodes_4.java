class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        
        int[] ans = new int[queries.length];
        int[] count = new int[n+1];
        int[] degree = new int[n+1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            degree[a]++;
            degree[b]++;
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            int key = a * n + b;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            count[degree[i]]++;
        }
        for (int i = 1; i <= n; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            for (int j = 1; j <= n; j++) {
                if (degree[j] <= q) {
                    continue;
                }
                int max = n;
                if (degree[j] - q - 1 < max) {
                    max = degree[j] - q - 1;
                }
                ans[i] += count[max];
                if (degree[j] - q <= n) {
                    ans[i] -= n - degree[j] + q + 1;
                }
                int min = 1;
                if (j - q > min) {
                    min = j - q;
                }
                if (min <= j - 1) {
                    ans[i] -= count[j - 1] - count[min - 1];
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int a = key / n;
                int b = key % n;
                int c = entry.getValue();
                if (degree[a] + degree[b] > q && degree[a] + degree[b] - c <= q) {
                    ans[i]--;
                }
            }
        }
        return ans;
    }
}