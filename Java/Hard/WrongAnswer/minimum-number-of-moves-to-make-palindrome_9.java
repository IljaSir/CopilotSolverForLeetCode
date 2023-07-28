class Solution {
    public int minMovesToMakePalindrome(String s) {
        
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] count = new int[26];
        for (char c : chars) {
            count[c - 'a']++;
        }
        int odd = 0;
        for (int i : count) {
            if (i % 2 == 1) {
                odd++;
            }
        }
        if (odd == 0 || odd == 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != chars[n - i - 1]) {
                res++;
            }
        }
        return res;
    }
}