class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        
        for(int i=0; i<edges.length; i++){
            edges[i][3] = i;
        }
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int min = getMSTWeight(n, edges, -1, -1);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for(int i=0; i<edges.length; i++){
            if(getMSTWeight(n, edges, i, -1) > min){
                result.get(0).add(edges[i][3]);
            }else if(getMSTWeight(n, edges, -1, i) == min){
                result.get(1).add(edges[i][3]);
            }
        }
        return result;
    }
    
    private int getMSTWeight(int n, int[][] edges, int exclude, int include){
        UnionFind uf = new UnionFind(n);
        int weight = 0;
        if(include >= 0){
            weight += edges[include][2];
            uf.union(edges[include][0], edges[include][1]);
        }
        for(int i=0; i<edges.length; i++){
            if(i == exclude) continue;
            if(uf.union(edges[i][0], edges[i][1])){
                weight += edges[i][2];
            }
        }
        if(uf.count != 1) return Integer.MAX_VALUE;
        return weight;
    }
    
    class UnionFind{
        int[] parents;
        int count;
        
        public UnionFind(int n){
            parents = new int[n];
            for(int i=0; i<n; i++){
                parents[i] = i;
            }
            count = n;
        }
        
        public int find(int i){
            if(parents[i] != i){
                parents[i] = find(parents[i]);
            }
            return parents[i];
        }
        
        public boolean union(int i, int j){
            int x = find(i);
            int y = find(j);
            if(x == y) return false;
            parents[x] = y;
            count--;
            return true;
        }
    }
}