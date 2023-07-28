class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.putIfAbsent(pair[1], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        int[] res = new int[adjacentPairs.length + 1];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                res[0] = entry.getKey();
                break;
            }
        }
        res[1] = map.get(res[0]).get(0);
        for (int i = 2; i < res.length; i++) {
            List<Integer> adj = map.get(res[i - 1]);
            res[i] = res[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return res;
    }
}