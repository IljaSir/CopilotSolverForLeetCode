class Solution {
    public int[] divisibilityArray(String word, int m) {
        
        int[] result = new int[word.length()];
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            p = ((p * 10) + (word.charAt(i) - '0')) % m;
            result[i] = p % m == 0 ? 1 : 0;
        }
        return result;
    }
}