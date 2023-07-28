class Solution {
    public int maximumPopulation(int[][] logs) {
        
        int[] year = new int[2051];
        for (int[] log : logs) {
            year[log[0]]++;
            year[log[1]]--;
        }
        int max = 0, result = 0;
        for (int i = 1950; i < 2051; i++) {
            year[i] += year[i - 1];
            if (year[i] > max) {
                max = year[i];
                result = i;
            }
        }
        return result;
    }
}