class Solution {
    public int numSplits(String s) {
        
        int[] left = new int[26];
        int[] right = new int[26];
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (right[c] == 0) {
                rightCount++;
            }
            right[c]++;
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            left[c]++;
            if (left[c] == 1) {
                leftCount++;
            }
            right[c]--;
            if (right[c] == 0) {
                rightCount--;
            }
            if (leftCount == rightCount) {
                result++;
            }
        }
        return result;
    }
}