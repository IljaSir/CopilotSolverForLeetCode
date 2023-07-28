class Solution {
    public int maximumPopulation(int[][] logs) {
        
        int[] count = new int[2051];
        for (int[] log : logs) {
            count[log[0]]++;
            count[log[1]]--;
        }
        int max = count[1950];
        int year = 1950;
        for (int i = 1951; i < 2051; i++) {
            count[i] += count[i - 1];
            if (count[i] > max) {
                max = count[i];
                year = i;
            }
        }
        return year;
    }
}