class Solution {
    public int maximumPopulation(int[][] logs) {
        
        int[] population = new int[101];
        for (int[] log : logs) {
            for (int i = log[0] - 1950; i < log[1] - 1950; i++) {
                population[i]++;
            }
        }
        int max = 0;
        int year = 0;
        for (int i = 0; i < population.length; i++) {
            if (population[i] > max) {
                max = population[i];
                year = i;
            }
        }
        return year + 1950;
    }
}