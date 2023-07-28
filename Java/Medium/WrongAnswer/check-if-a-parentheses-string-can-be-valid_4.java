class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int n = s.length();
        int[] cnt = new int[2];
        int[] lockedCnt = new int[2];
        for (int i = 0; i < n; ++i) {
            ++cnt[s.charAt(i) - '('];
            lockedCnt[locked.charAt(i) - '0']++;
        }
        if (cnt[0] < lockedCnt[1] || cnt[1] < lockedCnt[1]) {
            return false;
        }

        cnt[0] -= lockedCnt[1];
        cnt[1] -= lockedCnt[1];
        int unlockedLeft = cnt[0] - lockedCnt[0];
        int unlockedRight = cnt[1] - lockedCnt[0];
        return unlockedLeft == unlockedRight;
    }
}