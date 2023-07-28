class Solution {
    public int minimumBuckets(String hamsters) {
        
        int n = hamsters.length();
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H') {
                if (i > 0 && hamsters.charAt(i - 1) == '.') {
                    left++;
                }
                if (i < n - 1 && hamsters.charAt(i + 1) == '.') {
                    right++;
                }
            }
        }
        if (left == 0 && right == 0) {
            return 0;
        }
        if (left == 0 || right == 0) {
            return 1;
        }
        return 2;
    }
}