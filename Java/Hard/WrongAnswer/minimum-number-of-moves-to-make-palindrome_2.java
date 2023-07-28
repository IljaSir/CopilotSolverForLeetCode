class Solution {
    public int minMovesToMakePalindrome(String s) {
        
        int n = s.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - 'a';
        }
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            int[] cnt = new int[26];
            cnt[a[i]]++;
            cnt[a[n - i - 1]]++;
            int max = 0;
            for (int x : cnt) {
                max = Math.max(max, x);
            }
            ans += 2 - max;
        }
        return ans / 2;
    }
}