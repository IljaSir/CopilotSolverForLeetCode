class Solution {
    public int balancedString(String s) {
        
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }
        int i = 0;
        for (i = 0; i < n; i++) {
            if (cnt[s.charAt(i) - 'A'] > n / 4) {
                break;
            }
        }
        if (i == n) {
            return 0;
        }
        int j = 0;
        int res = n;
        for (; i < n; i++) {
            cnt[s.charAt(i) - 'A']--;
            while (j <= i && cnt['Q' - 'A'] <= n / 4 && cnt['W' - 'A'] <= n / 4 && cnt['E' - 'A'] <= n / 4 && cnt['R' - 'A'] <= n / 4) {
                res = Math.min(res, i - j + 1);
                cnt[s.charAt(j++) - 'A']++;
            }
        }
        return res;
    }
}