class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        
        int m = queries.length;
        int[] result = new int[m];
        int[] parent = new int[1 << n];
        for (int i = 0; i < parent.length; ++i) {
            parent[i] = i;
        }
        int[] depth = new int[1 << n];
        for (int i = 0; i < m; ++i) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int pa = getParent(a, parent);
            int pb = getParent(b, parent);
            if (pa == pb) {
                result[i] = depth[a] + depth[b] - 2 * depth[pa];
            } else {
                parent[pa] = pb;
                depth[pa] = depth[a] + depth[b] - depth[pb] + 1;
            }
        }
        return result;
    }

    private int getParent(int a, int[] parent) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = getParent(parent[a], parent);
    }
}
    }
}