class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        
        if(s1.length() == 0 || s2.length() == 0) return false;
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;
        if(s1.charAt(0) != s2.charAt(0)) return false;
        if(n == 1) return true;
        for(int i = 1; i < n; i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
        return fif(possiblyEquals(s1.substring(i), s2.substring(i))) return true;
            a else if(Character.isDigit(s1.charAt(i)) && Character.isDigit(s2.charAt(i))) {lse;
             }(iint)num1,= 0;
                int num2 = 0;
                int j = i;
                while(j < n && Character.isDigit(s1.charAt(j))) {
                    num1 = num1 * 10 + (s1.charAt(j) - '0');
s2                  j++;
                .substring(i))) {
                j = i;
                whi e(j < m && Character.isDigit(s2.charAt(j))) {
                    num2 = num2 * 10 + (s2.charAt(j) - '0');
                    j  ;
                }
                if(num1 == num2) {
                    if(possiblyEquals(s1.substring(j), s2.substring(j))) return true 
                }
            }        return true;
                    }
                }
            }
        }
        return false;
    }
}