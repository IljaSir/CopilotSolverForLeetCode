class Solution {
    public int[] divisibilityArray(String word, int m) {
        
        int[] result = new int[word.length()];
        int mod = 0;
        for (int i = 0; i < word.length(); i++) {
            mod = (mod * 10 + word.charAt(i) - '0') % m;
            result[i] = mod == 0 ? 1 : 0;
        }
        return result;
    }
}