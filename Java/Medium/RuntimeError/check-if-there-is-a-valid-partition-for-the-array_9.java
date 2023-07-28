class Solution {
    public boolean validPartition(int[] nums) {
        
        int len = nums.length;
        int[] cnt = new int[1000001];
        for (int x : nums) {
            cnt[x]++;
        }
        int[] right = new int[1000001];
        for (int i = 1; i <= 1000000; i++) {
            right[i] = right[i - 1] + cnt[i];
        }
        int[] left = new int[1000001];
        for (int i = 1000000; i >= 1; i--) {
            left[i] = left[i + 1] + cnt[i];
        }
        for (int i = 2; i <= 1000000; i++) {
            if (cnt[i] > 0) {
                if (cnt[i] >= 2) {
                    return true;
                }
                if (i > 1 && cnt[i - 1] > 0) {
                    return true;
                }
                if (i < 1000000 && cnt[i + 1] > 0) {
                    return true;
                }
                if (i > 2 && right[i - 2] > 0) {
                    return true;
                }
                if (i < 1000000 && left[i + 2] > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}