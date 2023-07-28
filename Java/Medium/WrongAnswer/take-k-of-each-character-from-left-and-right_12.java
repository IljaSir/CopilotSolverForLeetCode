class Solution {
    public int takeCharacters(String s, int k) {
        
        int n = s.length();
        int[] cnt = new int[3];
        int[] left = new int[3];
        int[] right = new int[3];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
            if (cnt[s.charAt(i) - 'a'] <= k) {
                left[s.charAt(i) - 'a']++;
            }
        }
        Arrays.fill(cnt, 0);
        for (int i = n - 1; i >= 0; i--) {
            cnt[s.charAt(i) - 'a']++;
            if (cnt[s.charAt(i) - 'a'] <= k) {
                right[s.charAt(i) - 'a']++;
            }
        }
        int ans = n;
        for (int i = 0; i < 3; i++) {
            if (cnt[i] < k) {
                return -1;
            }
            ans = Math.min(ans, n - left[i] - right[i]);
        }
        return ans;
    }
}