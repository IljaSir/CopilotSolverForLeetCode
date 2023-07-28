class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int[] sorted = score.clone();
        Arrays.sort(sorted);
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int idx = Arrays.binarySearch(sorted, score[i]);
            if (idx == score.length - 1) {
                result[i] = "Gold Medal";
            } else if (idx == score.length - 2) {
                result[i] = "Silver Medal";
            } else if (idx == score.length - 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = String.valueOf(score.length - idx);
            }
        }
        return result;
    }
}