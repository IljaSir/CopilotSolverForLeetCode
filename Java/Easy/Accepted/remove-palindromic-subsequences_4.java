class Solution {
    public int removePalindromeSub(String s) {
        
        if (s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return 2;
            }
        }
        return 1;
    }
}