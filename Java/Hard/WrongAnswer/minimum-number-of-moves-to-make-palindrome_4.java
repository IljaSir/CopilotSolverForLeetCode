class Solution {
    public int minMovesToMakePalindrome(String s) {
        
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; ++i) {
            count[s.charAt(i) - 'a']++;
        }
        int odd = 0;
        for (int c : count) {
            odd += c % 2;
        }
        int res = 0;
        for (int i = 0; i < n / 2; ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                res++;
            }
        }
        if (n % 2 == 1 && odd > 0) {
            res++;
        }
        return res;
    }
}