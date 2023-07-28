class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        
        int[] ans = new int[2];
        int aliceSum = 0, bobSum = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            aliceSum += aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.length; i++) {
            bobSum += bobSizes[i];
        }
        int diff = (bobSum - aliceSum) / 2;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < aliceSizes.length; i++) {
            set.add(aliceSizes[i]);
        }
        for (int i = 0; i < bobSizes.length; i++) {
            if (set.contains(bobSizes[i] - diff)) {
                ans[0] = bobSizes[i] - diff;
                ans[1] = bobSizes[i];
                break;
            }
        }
        return ans;
    }
}