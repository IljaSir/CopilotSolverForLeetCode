class Solution {
    public int minMovesToMakePalindrome(String s) {
        
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            arr[s.charAt(i) - 'a']++;
            arr[s.charAt(n - 1 - i) - 'a']--;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(arr[i]);
        }
        return res / 2;
    }
}