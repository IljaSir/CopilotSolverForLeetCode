class Solution {
    public int maxRepOpt1(String text) {
        
        int n = text.length();
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; ++i) {
            if (text.charAt(i) == text.charAt(i - 1)) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            if (text.charAt(i) == text.charAt(i + 1)) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int c = text.charAt(i) - 'a';
            if (count[c] == 1) {
                continue;
            }
            int x = left[i];
            int y = right[i];
            if (x + y == count[c]) {
                ans = Math.max(ans, x + y - 1);
            } else {
                ans = Math.max(ans, x + y);
            }
        }
        return ans;
    }
}