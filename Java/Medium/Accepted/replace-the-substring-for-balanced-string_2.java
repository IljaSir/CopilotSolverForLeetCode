class Solution {
    public int balancedString(String s) {
        
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'A']++;
        }
        int[] target = new int[26];
        for (int i = 0; i < 26; i++) {
            target[i] = n / 4;
        }
        int ans = n;
        int l = 0;
        for (int r = 0; r < n; r++) {
            count[s.charAt(r) - 'A']--;
            while (l < n && check(count, target)) {
                ans = Math.min(ans, r - l + 1);
                count[s.charAt(l) - 'A']++;
                l++;
            }
        }
        return ans;
    }
    public boolean check(int[] count, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (count[i] > target[i]) {
                return false;
            }
        }
        return true;
    }
}