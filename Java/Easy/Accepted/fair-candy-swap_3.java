class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        
        int asum = 0;
        int bsum = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            asum += aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.length; i++) {
            bsum += bobSizes[i];
        }
        int diff = (asum - bsum) / 2;
        for (int i = 0; i < aliceSizes.length; i++) {
            for (int j = 0; j < bobSizes.length; j++) {
                if (aliceSizes[i] - bobSizes[j] == diff) {
                    return new int[]{aliceSizes[i], bobSizes[j]};
                }
            }
        }
        return null;
    }
}