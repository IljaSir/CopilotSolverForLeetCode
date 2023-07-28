class Solution {
    public int numSplits(String s) {
        
        int[] left = new int[26];
        int[] right = new int[26];
        int leftCount = 0;
        int rightCount = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (right[index] == 0) {
                rightCount++;
            }
            right[index]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (left[index] == 0) {
                leftCount++;
            }
            left[index]++;
            right[index]--;
            if (right[index] == 0) {
                rightCount--;
            }
            if (leftCount == rightCount) {
                result++;
            }
        }
        return result;
    }
}