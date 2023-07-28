class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            map.put(match[0], map.getOrDefault(match[0], 0) + 1);
            map.put(match[1], map.getOrDefault(match[1], 0));
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                res.get(0).add(entry.getKey());
            } else if (entry.getValue() == 1) {
                res.get(1).add(entry.getKey());
            }
        }
        return res;
    }
}