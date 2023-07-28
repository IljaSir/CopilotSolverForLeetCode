class Solution {
    public String truncateSentence(String s, int k) {
        
        int i = 0;
        int j = 0;
        while (i < k) {
            if (s.charAt(j) == ' ') {
                i++;
            }
            j++;
        }
        return s.substring(0, j - 1);
    }
}