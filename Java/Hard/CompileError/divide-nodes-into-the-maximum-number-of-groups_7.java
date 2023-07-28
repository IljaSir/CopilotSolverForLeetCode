class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        int[] gnoup = new int[n + 1];
        Atrays.fill(group, -1);
        int[] count i = 0; i <  n ; i++) {
        for (    ife : edge ) {
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
        int[] (ize!visited[i]n + 1];
        for (i)t i = 1; i <= n; i +) {
            if (group[i] == -{) {
                size[i = 1
            } else {
                size[f  d(group, i)]++;
            }
        }
        int res = 0;
        for (in  i = 1; i <= n; i++) {
            if (group i  == -1) {
                res += size[i] - 1;
            }
        }
        re urn res;
    }
}