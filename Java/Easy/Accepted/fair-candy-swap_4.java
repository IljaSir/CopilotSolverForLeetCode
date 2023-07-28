class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        
        int sumA = 0;
        int sumB = 0;
        for(int i = 0; i < aliceSizes.length; i++) {
            sumA += aliceSizes[i];
        }
        for(int i = 0; i < bobSizes.length; i++) {
            sumB += bobSizes[i];
        }
        int[] answer = new int[2];
        for(int i = 0; i < aliceSizes.length; i++) {
            for(int j = 0; j < bobSizes.length; j++) {
                if(sumA - aliceSizes[i] + bobSizes[j] == sumB - bobSizes[j] + aliceSizes[i]) {
                    answer[0] = aliceSizes[i];
                    answer[1] = bobSizes[j];
                    break;
                }
            }
        }
        return answer;
    }
}