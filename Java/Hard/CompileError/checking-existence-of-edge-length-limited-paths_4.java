class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        
        int m = queries.length;
        boolean[] result = new boolean[m];
        for (int i = 0; i < m; i++) {
            result[i] = false;
        }
        int[][] queriesCopy = new int[m][3];
        for (int i = 0; i < m; i++) {
            queriesCopy[i][0] = queries[i][0];
            queriesCopy[i][1] = queries[i][1];
            queriesCopy[i][2] = i;
        }
        Arrays.sort(queriesCopy, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        Arrays.sort(edgeList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int[][] uf = new int[n][2];
        for (int i = 0; i < n; i++) {
            uf[i][0] = i;
            uf[i][1] = 1;
        }
        int i = 0;
        for (int[] q : queriesCopy) {
            while (i < edgeList.length && edgeList[i][2] < q[2]) {
                union(uf, edgeList[i][0], edgeList[i][1]);
                i++;
            }
            result[q[2]] = find(uf, q[0]) == find(uf, q[1]);
        }
        return result;
    }
    private int find(int[][] uf, int i) {
        if (uf[i][0] == i) {
            return i;
        }
        uf[i][0] = find(uf, uf[i][0]);
        return uf[i][0];
    }
    private void union(int[][] uf, int i, int j) {
        int a = find(uf, i);
        int b = find(uf, j);
        if (a == b) {
            return;
        }
        if (uf[a][1] > uf[b][1]) {
            uf[b][0] = a;
        } else if (uf[a][1] < uf[b][1]) {
            uf[a][0] = b;
    }
}