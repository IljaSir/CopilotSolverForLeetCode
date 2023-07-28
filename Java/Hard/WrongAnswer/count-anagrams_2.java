class Solution {
    public int countAnagrams(String s) {
        
        int n = s.length();
        int[] count = new int[26];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                res += countAnagrams(count);
                count = new int[26];
            } else {
                count[s.charAt(i) - 'a']++;
            }
        }
        res += countAnagrams(count);
        return res;
    }
    
    private int countAnagrams(int[] count) {
        int res = 1;
        int n = 0;
        for (int c : count) {
            if (c > 0) {
                n++;
                res *= factorial(c);
                res %= 1000000007;
            }
        }
        res *= factorial(n);
        res %= 1000000007;
        return res;
    }
    
    private int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= 1000000007;
        }
        return res;
    }
}