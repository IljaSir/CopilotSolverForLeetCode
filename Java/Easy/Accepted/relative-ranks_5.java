class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int[] sorted = Arrays.copyOf(score, score.length);
        Arrays.sort(sorted);
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int index = Arrays.binarySearch(sorted, score[i]);
            if (index == score.length - 1) {
                result[i] = "Gold Medal";
            } else if (index == score.length - 2) {
                result[i] = "Silver Medal";
            } else if (index == score.length - 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = String.valueOf(score.length - index);
            }
        }
        return result;
    }
}