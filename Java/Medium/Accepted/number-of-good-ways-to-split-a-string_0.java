class Solution {
    public int numSplits(String s) {
        
        int[] left = new int[26];
        int[] right = new int[26];
        for (int i = 0; i < s.length(); i++) {
            right[s.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            left[s.charAt(i) - 'a']++;
            right[s.charAt(i) - 'a']--;
            if (check(left, right)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean check(int[] left, int[] right) {
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < 26; i++) {
            if (left[i] > 0) {
                leftCount++;
            }
            if (right[i] > 0) {
                rightCount++;
            }
        }
        return leftCount == rightCount;
    }
}