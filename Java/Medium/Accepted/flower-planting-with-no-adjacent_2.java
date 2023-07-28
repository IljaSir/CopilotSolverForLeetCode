class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] path : paths) {
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Set<Integer> colors = new HashSet<>();
            for (int j : graph.get(i)) {
                colors.add(ans[j]);
            }
            for (int c = 1; c <= 4; c++) {
                if (!colors.contains(c)) {
                    ans[i] = c;
                    break;
                }
            }
        }
        return ans;
    }
}