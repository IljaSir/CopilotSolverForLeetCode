class Solution {
    public int[] divisibilityArray(String word, int m) {
        
        int[] result = new int[word.length()];
        int value = 0;
        for (int i = 0; i < word.length(); i++) {
            value = ((value * 10) + (word.charAt(i) - '0')) % m;
            result[i] = (value == 0) ? 1 : 0;
        }
        return result;
    }
}