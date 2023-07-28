class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        int[] res = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] path : paths) {
            map.get(path[0] - 1).add(path[1] - 1);
            map.get(path[1] - 1).add(path[0] - 1);
        }
        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[5];
            for (int j : map.get(i)) {
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