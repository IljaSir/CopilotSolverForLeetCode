class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        int[] res = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        }
        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[5];
            for (int j : graph.get(i)) {
                used[res[j]] = true;
            }
            for (int k = 1; k <= 4; k++) {
                if (!used[k]) {
                    res[i] = k;
                }
            }
        }
        return res;
    }
}