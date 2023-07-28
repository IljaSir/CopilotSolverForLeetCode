class Solution {
    public int minMovesToMakePalindrome(String s) {
        
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            count[s.charAt(i) - 'a']++;
            count[s.charAt(n - i - 1) - 'a']--;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                odd++;
            }
        }
        return (odd + 1) / 2;
    }
}