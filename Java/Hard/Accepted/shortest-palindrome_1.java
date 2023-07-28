class Solution {
    public String shortestPalindrome(String s) {
        
        int n = s.length();
        int i = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        if (i == n) {
            return s;
        }
        String remain = s.substring(i);
        String remainReverse = new StringBuilder(remain).reverse().toString();
        String prefix = remainReverse + shortestPalindrome(s.substring(0, i)) + remain;
        return prefix;
    }
}