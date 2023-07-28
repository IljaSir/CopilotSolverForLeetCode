class Solution {
    public int maximumPopulation(int[][] logs) {
        
        int[] years = new int[101];
        for (int[] log : logs) {
            for (int i = log[0] - 1950; i < log[1] - 1950; i++) {
                years[i]++;
            }
        }
        int max = 0;
        int maxYear = 0;
        for (int i = 0; i < 101; i++) {
            if (years[i] > max) {
                max = years[i];
                maxYear = i;
            }
        }
        return 1950 + maxYear;
    }
}