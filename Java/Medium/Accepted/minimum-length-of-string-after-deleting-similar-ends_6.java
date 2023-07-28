class Solution {
    public int minimumLength(String s) {
        
        int len = s.length();
        int i = 0;
        int j = len - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            char c = s.charAt(i);
            while (i <= j && s.charAt(i) == c) {
                i++;
            }
            while (i <= j && s.charAt(j) == c) {
                j--;
            }
        }
        return j - i + 1;
    }
}