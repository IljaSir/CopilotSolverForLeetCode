class Solution {
    public boolean checkIfPangram(String sentence) {
        
        char[] arr = sentence.toCharArray();
        int[] count = new int[26];
        for (char c : arr) {
            count[c - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                return false;
            }
        }
        return true;
    }
}