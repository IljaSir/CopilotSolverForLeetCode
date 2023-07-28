class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int n = score.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> score[j] - score[i]);
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans[idx[i]] = "Gold Medal";
            } else if (i == 1) {
                ans[idx[i]] = "Silver Medal";
            } else if (i == 2) {
                ans[idx[i]] = "Bronze Medal";
            } else {
                ans[idx[i]] = String.valueOf(i + 1);
            }
        }
        return ans;
    }
}