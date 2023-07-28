class Solution {
    public boolean validPartition(int[] nums) {
        
        int[] cnt = new int[1000001];
        for (int n : nums) {
            cnt[n]++;
        }
        int prev = -1, prevCnt = 0;
        for (int i = 1; i <= 1000000; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            if (prev == i - 1) {
                if (cnt[i] == 1) {
                    if (prevCnt > 1) {
                        prev = i;
                        prevCnt = cnt[i];
                    } else {
                        return false;
                    }
                } else if (cnt[i] == 2) {
                    prev = i;
                    prevCnt = cnt[i];
                } else {
                    return false;
                }
            } else {
                if (cnt[i] > 2) {
                    return false;
                } else {
                    prev = i;
                    prevCnt = cnt[i];
                }
            }
        }
        return true;
    }
}