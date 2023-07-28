class Solution {
    public int maximumPopulation(int[][] logs) {
        
        int[] years = new int[2051];
        for (int[] log : logs) {
            years[log[0]]++;
            years[log[1]]--;
        }
        int max = 0;
        int year = 0;
        int current = 0;
        for (int i = 1950; i <= 2050; i++) {
            current += years[i];
            if (current > max) {
                max = current;
                year = i;
            }
        }
        return year;
    }
}