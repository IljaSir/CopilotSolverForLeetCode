class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        
        List<Boolean> res = new ArrayList<>();
        if (threshold == 0) {
            for (int i = 0; i < queries.length; i++) {
                res.add(true);
            }
            return res;
        }
        int[] parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        for (int i = threshold + 1; i <= n; i++) {
            for (int j = 2; j * i <= n; j++) {
                int p1 = find(parents, i);
                int p2 = find(parents, j * i);
                if (p1 != p2) {
                    parents[p1] = p2;
                }
            }
        }
        for (int[] query : queries) {
            int p1 = find(parents, query[0]);
            int p2 = find(parents, query[1]);
            res.add(p1 == p2);
        }
        return res;
    }
    private int find(int[] parents, int i) {
        if (parents[i] == i) {
            return i;
        }
        return parents[i] = find(parents, parents[i]);
    }
}