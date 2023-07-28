class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        
        long maxBeauty = 0;
        int[] flowersCount = new int[flowers.length + 1];
        int[] completeCount = new int[flowers.length + 1];
        for (int i = 0; i < flowers.length; i++) {
            flowersCount[flowers[i]]++;
            if (flowers[i] >= target) {
                completeCount[flowers[i]]++;
            }
        }
        for (int i = 1; i < flowersCount.length; i++) {
            flowersCount[i] += flowersCount[i - 1];
            completeCount[i] += completeCount[i - 1];
        }
        for (int i = 0; i < flowersCount.length; i++) {
            int flowersToPlant = (int) Math.min(newFlowers, flowersCount[flowersCount.length - 1] - flowersCount[i]);
            int completeGardens = completeCount[flowersCount.length - 1] - completeCount[i];
            int incompleteGardens = flowersCount.length - 1 - i - completeGardens;
            int minFlowers = incompleteGardens > 0 ? 1 : 0;
            maxBeauty = Math.max(maxBeauty, (long) (completeGardens * full + minFlowers * partial) * flowersToPlant);
            newFlowers -= flowersToPlant;
            if (newFlowers == 0) {
                break;
            }
        }
        return maxBeauty;
    }
}