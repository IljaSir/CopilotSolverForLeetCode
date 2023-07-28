class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        long ans = 0;
        for (int i = 0; i < k; i++) {
            int max = 0;
            int index = 0;
            for (int j = 0; j < gifts.length; j++) {
                if (gifts[j] > max) {
                    max = gifts[j];
                    index = j;
                }
            }
            gifts[index] = (int) Math.floor(Math.sqrt(gifts[index]));
        }
        for (int i = 0; i < gifts.length; i++) {
            ans += gifts[i];
        }
        return ans;
    }
}