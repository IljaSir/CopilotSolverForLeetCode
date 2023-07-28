class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int n = score.length;
        String[] result = new String[n];
        int[] copy = Arrays.copyOf(score, n);
        Arrays.sort(copy);
        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(copy, score[i]);
            if (index == n - 1) {
                result[i] = "Gold Medal";
            } else if (index == n - 2) {
                result[i] = "Silver Medal";
            } else if (index == n - 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = String.valueOf(n - index);
            }
        }
        return result;
    }
}