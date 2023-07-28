class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        
        int[] answer = new int[queries.length];
        int[] parent = new int[1 << n];
        int[] size = new int[1 << n];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i / 2;
            size[i] = 1;
        }
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int pa = find(a, parent);
            int pb = find(b, parent);
            if (pa == pb) {
                answer[i] = size[pa];
            } else {
                answer[i] = size[pa] + size[pb];
                parent[pa] = pb;
                size[pb] += size[pa];
            }
        }
        return answer;
    }
    
    private int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
}