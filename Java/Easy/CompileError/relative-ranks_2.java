class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int n = score.length;
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = i;
        }
        Arrays.sort(rank, (a, b) -> score[b] - score[a]);
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[rank[i]] = "Gold Medal";
            } else if (i == 1) {
                result[rank[i]] = "Silver Medal";
            } else if (i == 2) {
                result[rank[i]] = "Bronze Medal";
            } else {
                result[rank[i]] = String.valueOf(i + 1);
            }
        }
        return result;
    }
}