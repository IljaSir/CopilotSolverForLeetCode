class Solution {
    public int minimumLength(String s) {
        
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char c = s.charAt(i);
            if (s.charAt(j) == c) {
                while (i < j && s.charAt(i) == c) {
                    i++;
                }
                while (i < j && s.charAt(j) == c) {
                    j--;
                }
            } else {
                break;
            }
        }

        return j - i + 1;
    }
}