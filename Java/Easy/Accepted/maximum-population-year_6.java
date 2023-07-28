class Solution {
    public int maximumPopulation(int[][] logs) {
        
        int[] pop = new int[2051];
        for (int[] log : logs) {
            pop[log[0]]++;
            pop[log[1]]--;
        }
        int maxPop = 0;
        int maxYear = 0;
        int curPop = 0;
        for (int i = 1950; i <= 2050; i++) {
            curPop += pop[i];
            if (curPop > maxPop) {
                maxPop = curPop;
                maxYear = i;
            }
        }
        return maxYear;
    }
}