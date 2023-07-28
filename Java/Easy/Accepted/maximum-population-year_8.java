class Solution {
    public int maximumPopulation(int[][] logs) {
        
        int[] years = new int[2051];
        for (int[] log : logs) {
            years[log[0]]++;
            years[log[1]]--;
        }
        int max = 0, index = 0;
        for (int i = 1950; i < 2051; i++) {
            years[i] += years[i - 1];
            if (years[i] > max) {
                max = years[i];
                index = i;
            }
        }
        return index;
    }
}