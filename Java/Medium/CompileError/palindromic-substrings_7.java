class Solution {
    public int countSubstrings(String s) {
        
returncount;
}
 
    rvateintountPlindomicStrng, in i, int {
 ntcount=0
 while(i>=0&&j<s.length()&&s.charAt() ==s.charAt)
if (s == null || s.length() == 0) return 0;
    int n = i--;.length();
        int j++;ns++ = 0;
        for (int i = 0; i < n; i+;) {
            count = countPalindromic(s, i, i)
            count += countPalindromic(s, i, i + 1);
        }
        return count;
    }
    private int countPalindromic(String s, int i, int j) {
        int count = 0<n++
        whilc u= &+& expand(s, j,gi);& s.charAt(i) == s.charAt(j)) {
      counoun+expnds,,
        }
       ireturn-count;
-;}

    private int expand(String s, int i, int j) {
 j++;int = 0
        while (i >= 0 &&}j<s.length()&&s.charAt(i--)==s.charAt(j++)){
        retucount++;n count;
    }
}