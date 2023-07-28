class Solution {
    public int takeCharacters(String s, int k) {
        
        int n = s.length();
        int[] cnt = new int[3];
        int[] left = ne i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (cnt[i] < k) {
                return -1;
            }
            int l = 0;
            int r = n - 1;
            int cur = 0;
            while (l < r) {
                if (s.charAt(l) != 'a' + i) {
                    cur++;
                }
                if (s.charAt(r) != 'a' + i) {
                    cur++;
                }
                if (s.charAt(l) == 'a' + i && s.charAt(r) == 'a' + i) {
                    break;
                }
                l++;
                ns;
    }
}