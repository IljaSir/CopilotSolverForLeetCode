class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        int max = 0;
        for (int[] match : matches) {
            max = Math.max(max, match[0]);
            max = Math.max(max, match[1]);
        }
        int[] wins = new int[max + 1];
        int[] losses = new int[max + 1];
        for (int[] match : matches) {
            wins[match[0]]++;
            losses[match[1]]++;
        }
        List<Integer> noLosses = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            if (losses[i] == 0) {
                noLosses.add(i);
            } else if (losses[i] == 1) {
                oneLoss.add(i);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(noLosses);
        result.add(oneLoss);
        return result;
    }
}