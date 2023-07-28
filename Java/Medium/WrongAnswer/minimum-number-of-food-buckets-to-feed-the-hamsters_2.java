class Solution {
    public int minimumBuckets(String hamsters) {
        
        int n = hamsters.length();
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H') {
                if (i == 0) {
                    right++;
                } else if (i == n - 1) {
                    left++;
                } else {
                    left++;
                    right++;
                }
            }
        }
        if (left > 0 && right > 0) {
            return -1;
        } else {
            return Math.max(left, right);
        }
    }
}