class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        
        int n = adjacentPairs.length + 1;
        int[] res = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            map.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            map.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }
        int start = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }
        res[0] = start;
        res[1] = map.get(start).get(0);
        for (int i = 2; i < n; ++i) {
            List<Integer> adj = map.get(res[i - 1]);
            res[i] = adj.get(0) == res[i - 2] ? adj.get(1) : adj.get(0);
        }
        return res;
    }
}