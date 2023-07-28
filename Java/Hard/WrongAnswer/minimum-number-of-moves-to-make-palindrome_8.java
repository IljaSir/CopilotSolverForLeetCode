class Solution {
    public int minMovesToMakePalindrome(String s) {
        
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += cnt[i] / 2;
        }
        int res = 0;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                res++;
            }
            i++;
            j--;
        }
        return s.length() - 2 * sum + res;
    }
}