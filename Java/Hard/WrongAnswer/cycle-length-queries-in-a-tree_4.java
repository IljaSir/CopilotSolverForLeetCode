class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        
        int[] answer = new int[queries.length];
        int[] parent = new int[1 << n];
        int[] depth = new int[1 << n];
        int[] size = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            parent[i] = i;
            depth[i] = 0;
            size[i] = 1;
        }
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int pa = findParent(parent, a);
            int pb = findParent(parent, b);
            if (pa == pb) {
                answer[i] = -1;
            } else {
                if (depth[pa] > depth[pb]) {
                    int tmp = pa;
                    pa = pb;
                    pb = tmp;
                }
                parent[pa] = pb;
                size[pb] += size[pa];
                if (depth[pa] == depth[pb]) {
                    depth[pb]++;
                }
                answer[i] = (size[pb] - 1) * 2;
            }
        }
        return answer;
    }

    private int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }
}