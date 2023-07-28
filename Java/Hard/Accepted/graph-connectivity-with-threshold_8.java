class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        
        List<Boolean> res = new ArrayList<>();
        int[] parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        for(int i = threshold + 1; i <= n; i++){
            for(int j = i + i; j <= n; j += i){
                union(parent, i, j);
            }
        }
        for(int[] q: queries){
            res.add(find(parent, q[0]) == find(parent, q[1]));
        }
        return res;
    }
    private int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    private void union(int[] parent, int x, int y){
        int rootx = find(parent, x);
        int rooty = find(parent, y);
        if(rootx != rooty){
            parent[rootx] = rooty;
        }
    }
}