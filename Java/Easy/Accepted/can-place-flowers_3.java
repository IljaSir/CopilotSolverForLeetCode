class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int count = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len && count < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int prev = (i == 0) ? 0 : flowerbed[i - 1];
            int next = (i == len - 1) ? 0 : flowerbed[i + 1];
            if (prev == 0 && next == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count == n;
    }
}