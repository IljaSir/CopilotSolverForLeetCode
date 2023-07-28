class Solution {
    public int minSwaps(String s) {
        
        int left = 0;
        int right = 0;
        int swaps = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                left++;
            } else {
                right++;
            }
            if (left < right) {
                swaps++;
                left++;
                right--;
            }
        }
        return swaps;
    }
}