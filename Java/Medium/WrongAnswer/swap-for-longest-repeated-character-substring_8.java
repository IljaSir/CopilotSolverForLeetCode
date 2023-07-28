class Solution {
    public int maxRepOpt1(String text) {
        
        int N = text.length();
        int[] count = new int[26];
        int[] rightmost = new int[26];
        for (int i = 0; i < N; ++i) {
            count[text.charAt(i) - 'a']++;
            rightmost[text.charAt(i) - 'a'] = i;
        }

        int ans = 0;
        for (int i = 0; i < N; ) {
            int j = i;
            while (j < N && text.charAt(j) == text.charAt(i)) j++;
            int same = j - i;  // How many of the same character?

            // Try to extend the window by one character on each side.
            int extend = Math.min(count[text.charAt(i) - 'a'] - same, 1);
            int left = i - 1;
            int right = j;
            while (left >= 0 && right < N && text.charAt(left) == text.charAt(right) && right - left - 1 <= same + extend) {
                if (text.charAt(left) == text.charAt(i)) same++;
                left--;
                right++;
            }

            ans = Math.max(ans, right - left - 1);
            i = j;
        }

        return ans;
    }
}