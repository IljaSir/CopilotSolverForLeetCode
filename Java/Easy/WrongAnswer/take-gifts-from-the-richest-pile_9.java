class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        long[] giftsCount = new long[1000001];
        for (int gift : gifts) {
            giftsCount[gift]++;
        }
        long sum = 0;
        for (int i = giftsCount.length - 1; i >= 0; i--) {
            if (giftsCount[i] == 0) {
                continue;
            }
            if (k >= giftsCount[i]) {
                sum += giftsCount[i] * i;
                k -= giftsCount[i];
            } else {
                sum += k * i;
                break;
            }
        }
        return sum;
    }
}