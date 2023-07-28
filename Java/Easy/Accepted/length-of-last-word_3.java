class Solution {
    public int lengthOfLastWord(String s) {
        
        int len = s.length();
        int res = 0;
        int i = len - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            res++;
            i--;
        }
        return res;
    }
}