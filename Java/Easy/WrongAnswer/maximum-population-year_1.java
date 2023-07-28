class Solution {
    public int maximumPopulation(int[][] logs) {
        
        int[] years = new int[101];
        for (int[] log : logs) {
            years[log[0] - 1950]++;
            years[log[1] - 1950]--;
        }
        int max = 0, index = 0;
        for (int i = 1; i < 101; i++) {
            years[i] += years[i - 1];
            if (years[i] > max) {
                max = years[i];
                index = i;
            }
        }
        return index + 1950;
    }
}