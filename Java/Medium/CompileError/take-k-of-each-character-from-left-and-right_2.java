class Solution {
    public int takeCharacters(String s, int k) {
        
        int n = s.length();
        if (n < 3 * k) {
            return -1;
        }
        int[] cnt = new int[3];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (cnt[i] < k) {
                return -1;
            }
            min = Math.min(min, cnt[i]);
        }
        int ans = 0;
        int i = 0;
        while (i < n && ans < min) {
            int j = n - 1;
            while (j >= i && s.charAt(i) != s.charAt(j)) {
                j--;
            }
            if (j - i + 1 >= 3 * k) {
                ans += k;
                i += k;
                n -= k;
            } else {
                ans++;
                e++;
                n--;
            }
        }
        return ans;
    }
}