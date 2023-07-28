class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        int[] res = new int[n];
        ArrayList<Integer>[] graph = new ArrayList[n];
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
                used[res[j]] = true;
            }
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}