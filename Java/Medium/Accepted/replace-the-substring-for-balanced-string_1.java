class Solution {
    public int balancedString(String s) {
        
        int n = s.length();
        int k = n / 4;
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'A']++;
        }
        int l = 0;
        int r = 0;
        int ans = n;
        while (r < n) {
            count[s.charAt(r) - 'A']--;
            while (l < n && count['Q' - 'A'] <= k && count['W' - 'A'] <= k && count['E' - 'A'] <= k && count['R' - 'A'] <= k) {
                ans = Math.min(ans, r - l + 1);
                count[s.charAt(l) - 'A']++;
                l++;
            }
            r++;
        }
        return ans;
    }
}