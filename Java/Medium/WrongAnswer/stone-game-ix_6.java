class Solution {
    public boolean stoneGameIX(int[] stones) {
        
        int sum = 0;
        int[] cnt = new int[3];
        for (int stone : stones) {
            sum += stone;
            cnt[stone % 3]++;
        }
        if (sum % 3 == 0) {
            return cnt[0] > 0 && cnt[1] > 0;
        } else if (sum % 3 == 1) {
            return cnt[2] > 0 && cnt[1] > 1;
        } else {
            return cnt[2] > 1 && cnt[0] > 0;
        }
    }
}