class Solution {
    public int numSplits(String s) {
        
        int[] left = new int[26];
        int[] right = new int[26];
        int leftCount = 0;
        int rightCount = 0;
        for (char c : s.toCharArray()) {
            if (right[c - 'a'] == 0) {
                rightCount++;
            }
            right[c - 'a']++;
        }
        int result = 0;
        for (char c : s.toCharArray()) {
            left[c - 'a']++;
            if (left[c - 'a'] == 1) {
                leftCount++;
            }
            right[c - 'a']--;
            if (right[c - 'a'] == 0) {
                rightCount--;
            }
            if (leftCount == rightCount) {
                result++;
            }
        }
        return result;
    }
}