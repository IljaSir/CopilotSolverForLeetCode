class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> winners = new HashSet<>();
        Set<Integer> losers = new HashSet<>();
        for (int[] match : matches) {
            winners.add(match[0]);
            losers.add(match[1]);
        }
        result.add(new ArrayList<>(winners));
        result.add(new ArrayList<>(losers));
        return result;
    }
}