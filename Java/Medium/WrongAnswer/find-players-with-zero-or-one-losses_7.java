class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }
        List<Integer> winners = new ArrayList<>();
        List<Integer> losers = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == 0) {
                winners.add(key);
            } else if (map.get(key) == 1) {
                losers.add(key);
            }
        }
        res.add(winners);
        res.add(losers);
        return res;
    }
}