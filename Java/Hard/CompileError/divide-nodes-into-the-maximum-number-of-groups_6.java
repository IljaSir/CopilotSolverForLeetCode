class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        int[] group = new int[n];
        Arrays.fill(group, -1);
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0] - 1).add(edge[1] - 1);
            adj.get(edge[1] - 1).add(edge[0] - 1);
        }
        int[] groups = new int[n];
        Arrays.fill(groups, -1);
        int grou = new int[n+1];
        int[] rr = new int[n+1];
        int[] ss = new int[n+1];
p       int[] tt Count = 0;
        for (iuu
    }
}