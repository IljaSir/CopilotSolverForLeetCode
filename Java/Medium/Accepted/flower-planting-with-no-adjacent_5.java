class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        int[] result = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            graph[path[0] - 1].add(path[1] - 1);
            graph[path[1] - 1].add(path[0] - 1);
        }
        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[5];
            for (int j : graph[i]) {
                used[result[j]] = true;
            }
            for (int k = 1; k <= 4; k++) {
                if (!used[k]) {
                    result[i] = k;
                }
            }
        }
        return result;
    }
}