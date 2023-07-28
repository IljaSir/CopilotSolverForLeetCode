class Solution {
    public int balancedString(String s) {
        
        int n = s.length();
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'A']++;
        }
        int k = n / 4;
        int lo = 0;
        int hi = 0;
        int res = n;
        while (hi < n) {
            map[s.charAt(hi) - 'A']--;
            while (lo <= hi && map['Q' - 'A'] <= k && map['W' - 'A'] <= k && map['E' - 'A'] <= k && map['R' - 'A'] <= k) {
                res = Math.min(res, hi - lo + 1);
                map[s.charAt(lo) - 'A']++;
                lo++;
            }
            hi++;
        }
        return res;
    }
}