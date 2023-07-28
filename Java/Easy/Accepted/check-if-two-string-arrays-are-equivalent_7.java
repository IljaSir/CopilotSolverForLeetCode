class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        int i = 0, j = 0;
        int w1 = 0, w2 = 0;
        while (i < word1.length && j < word2.length) {
            if (w1 >= word1[i].length()) {
                i++;
                w1 = 0;
            }
            if (w2 >= word2[j].length()) {
                j++;
                w2 = 0;
            }
            if (i >= word1.length || j >= word2.length) {
                break;
            }
            if (word1[i].charAt(w1) != word2[j].charAt(w2)) {
                return false;
            }
            w1++;
            w2++;
        }
        return i >= word1.length && j >= word2.length;
    }
}