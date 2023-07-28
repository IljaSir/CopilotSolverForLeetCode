class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        
        int[] result = new int[2];
        int sumAlice = 0;
        int sumBob = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            sumAlice += aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.length; i++) {
            sumBob += bobSizes[i];
        }
        int diff = (sumAlice - sumBob) / 2;
        for (int i = 0; i < aliceSizes.length; i++) {
            for (int j = 0; j < bobSizes.length; j++) {
                if (aliceSizes[i] - bobSizes[j] == diff) {
                    result[0] = aliceSizes[i];
                    result[1] = bobSizes[j];
                }
            }
        }
        return result;
    }
}