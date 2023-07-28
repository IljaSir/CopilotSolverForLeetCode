class Solution {
    public int maxPalindromes(String s, int k) {
        
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            odd += count[i] % 2;
        }
        if (k >= n) {
            return 1;
        } else if (k >= n - odd + 1) {
            return odd == 0 ? 0 : 1;
        } else {
            return odd;
        }
    }
}