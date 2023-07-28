class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        int[][] result = new int[pairs.length][2];
        int[] start = new int[pairs.length];
        int[] end = new int[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            start[i] = pairs[i][0];
            end[i] = pairs[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0;
        for (int k = 0; k < pairs.length; k++) {
            if (i < pairs.length && start[i] == end[j]) {
                result[k][0] = start[i];
                result[k][1] = end[j];
                i++;
                j++;
            } else if (i < pairs.length && start[i] < end[j]) {
                result[k][0] = start[i];
                i++;
            } else {
                result[k][0] = end[j];
                j++;
            }
        }
        return result;
    }
}