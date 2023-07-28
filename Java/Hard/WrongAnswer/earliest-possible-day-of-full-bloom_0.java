class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        int n = plantTime.length;
        int[] bloomTime = new int[n];
        for (int i = 0; i < n; i++) {
            bloomTime[i] = plantTime[i] + growTime[i];
        }
        Arrays.sort(bloomTime);
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, plantTime[i]) + growTime[i];
            if (max < bloomTime[i]) {
                max = bloomTime[i];
            }
        }
        return max;
    }
}