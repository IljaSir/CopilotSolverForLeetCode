class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            sumA += aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.length; i++) {
            sumB += bobSizes[i];
        }
        int[] res = new int[2];
        if (sumA > sumB) {
            int diff = (sumA - sumB) / 2;
            for (int i = 0; i < aliceSizes.length; i++) {
                for (int j = 0; j < bobSizes.length; j++) {
                    if (aliceSizes[i] - bobSizes[j] == diff) {
                        res[0] = aliceSizes[i];
                        res[1] = bobSizes[j];
                        break;
                    }
                }
            }
        } else {
            int diff = (sumB - sumA) / 2;
            for (int i = 0; i < bobSizes.length; i++) {
                for (int j = 0; j < aliceSizes.length; j++) {
                    if (bobSizes[i] - aliceSizes[j] == diff) {
                        res[0] = aliceSizes[j];
                        res[1] = bobSizes[i];
                        break;
                    }
                }
            }
        }
        return res;
    }
}