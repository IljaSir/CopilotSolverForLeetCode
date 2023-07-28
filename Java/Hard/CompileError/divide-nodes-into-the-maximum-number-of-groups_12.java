class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        int[] group = new int[n + 1];
        Arrays.fill(group, -1);
        int[] count = new int[n + 1];
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            int g1 = find(group, a), g2 = find(group, b);
            if (g1 == g2) continue;
            if (count[g1] < count[g2]) {
                group[g1] = g2;
                count[g2] += count[g1];
            } else {
                group[g2] = g1;
                count[g1] += count[g2];
            }
        }
        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (group[i] == -1) {
                size[i] = 1;
            } else {
                size[find(group, i)]++;
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (group[i] == -1) {
                res += size[i] - 1;
            }
        }
        return res;
    }
}