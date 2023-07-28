class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        
        int[] result = new int[2];
        int sa = 0;
        int sb = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            sa += aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.length; i++) {
            sb += bobSizes[i];
        }
        int diff = (sb - sa) / 2;
        for (int i = 0; i < aliceSizes.length; i++) {
            for (int j = 0; j < bobSizes.length; j++) {
                if (bobSizes[j] - aliceSizes[i] == diff) {
                    result[0] = aliceSizes[i];
                    result[1] = bobSizes[j];
                    return result;
                }
            }
        }
        return result;
    }
}