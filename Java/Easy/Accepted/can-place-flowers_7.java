class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int count = 0;
        int prev = 0;
        int next = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 1) {
                continue;
            }
            prev = i == 0 ? 0 : flowerbed[i - 1];
            next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if(prev == 0 && next == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }
}