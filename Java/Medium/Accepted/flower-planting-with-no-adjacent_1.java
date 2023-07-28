class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] path : paths) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            boolean[] used = new boolean[5];
            for (int neighbor : graph.get(i)) {
                used[res[neighbor - 1]] = true;
            }
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {
                    res[i - 1] = j;
                }
            }
        }
        return res;
    }
}