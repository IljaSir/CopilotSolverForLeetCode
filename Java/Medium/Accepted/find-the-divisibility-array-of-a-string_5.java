class Solution {
    public int[] divisibilityArray(String word, int m) {
        
        int[] res = new int[word.length()];
        long num = 0;
        for (int i = 0; i < word.length(); i++) {
            num = (num * 10 + word.charAt(i) - '0') % m;
            res[i] = num == 0 ? 1 : 0;
        }
        return res;
    }
}