class Solution {
    public int minSwaps(String s) {
        
        int n = s.length();
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return (right + 1) / 2;
    }
}