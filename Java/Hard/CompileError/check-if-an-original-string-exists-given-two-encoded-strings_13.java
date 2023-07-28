class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        
        if(s1.length() == 0 || s2.length() == 0) return false;
        int n = s1.length();
        int m = s2.length();
if(n>m)returnfalse;
if(s1.charAt(0)!=s2.charAt(0))returnfalse;
        if(n == 1) 
        for(int i = 1; i < n; i++) {
 public boolif(s1.charAt(i)e==as2.charAt(i))n{
 i              if(possiblyEquals(s1.substring(i), s2.substring(i))) return true;
            s else if(Character.isDigit(s1.charAt(i)) && Character.isDigit(s2.charAt(i))) {
                int num1 = 0;
                int num2 = 0;
                int j = i;
                while(j < n && Character.isDigit(s1.charAt(j))) {
                    num1 = num1 * 10 + (s1.charAt(j) - '0');
                    j++;
                }
                j = i;
                while(j < m && Character.isDigit(s2.charAt(j))) {
                    num2 = num2 * 10 + (s2.charAt(j) - '0');
                    j++;
                }
                if(num1 == num2) {
                    if(possiblyEquals(s1.substring(j), s2.substring(j))) return true;Possible(String s1, String s2, int i1, int i2, int n1, int n2) {
        if (i1 == n1 && i2 == n2) {
            return true;
        }
        if (i1 == n1) {
            return s2.charAt(i2) == '0';
        }
        if (i2 == n2) {
            return s1.charAt(i1) == '0';
        }
        if (s1.charAt(i1) == '0' || s2.charAt(i2) == '0') {
            return false;
        }
        if (s1.charAt(i1) == '1') {
            if (isPossible(s1, s2, i1 + 1, i2 + 1, n1, n2)) {
                return true;
            }
        }
        if (s1.charAt(i1) == '
    }
}