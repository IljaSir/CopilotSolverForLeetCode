class Solution {
    public int longestContinuousSubstring(String s) {
        
        int max = 0;
        int count = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] > arr[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}