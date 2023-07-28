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
        if (sumA > sumB) {
            int[] res = fairCandySwap(bobSizes, aliceSizes);
            return new int[]{res[1], res[0]};
        }
        int delta = (sumB - sumA) / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < bobSizes.length; i++) {
            set.add(bobSizes[i]);
        }
        for (int i = 0; i < aliceSizes.length; i++) {
            if (set.contains(aliceSizes[i] + delta)) {
                return new int[]{aliceSizes[i], aliceSizes[i] + delta};
            }
        }
        return null;
    }
}