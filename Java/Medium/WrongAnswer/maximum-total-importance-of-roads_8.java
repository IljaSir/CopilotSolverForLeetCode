class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        long[] importance = new long[n];
        for (int[] road : roads) {
            importance[road[0]]++;
            importance[road[1]]++;
        }
        return Arrays.stream(importance).sum();
    }
}