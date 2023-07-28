class Solution {
    public int longestPalindrome(String[] words) {
        
        int[] arr = new int[26 * 26];
        for (String word : words) {
            int temp = (word.charAt(0) - 'a') * 26 + (word.charAt(1) - 'a');
            arr[temp] = Math.max(arr[temp], word.length());
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = Math.max(ans, arr[i * 26 + i]);
        }
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                ans = Math.max(ans, arr[i * 26 + j] + arr[j * 26 + i]);
            }
        }
        return ans;
    }
}