class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        int n = plantTime.length;
        int[] bloomTime = new int[n];
        for (int i = 0; i < n; i++) {
            bloomTime[i] = plantTime[i] + growTime[i];
        }
        Arrays.sort(bloomTime);
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            maxTime = Math.max(maxTime, bloomTime[i] + i);
        }
        return maxTime;
    }
}