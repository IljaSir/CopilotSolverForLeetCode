class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int n = score.length;
        int[] sorted = Arrays.copyOf(score, n);
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sorted[i], n - i);
        }
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            int rank = map.get(score[i]);
            if (rank == 1) {
                result[i] = "Gold Medal";
            } else if (rank == 2) {
                result[i] = "Silver Medal";
            } else if (rank == 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = String.valueOf(rank);
            }
        }
        return result;
    }
}