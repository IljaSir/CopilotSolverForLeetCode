class Solution {
    public int minimumTime(String s) {
        
        int n = s.length();
        int count = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        if (s.charAt(0) == '1') {
            ans += 2;
        }
        if (s.charAt(n - 1) == '1') {
            ans += 2;
        }
        if (s.charAt(0) == '1' && s.charAt(n - 1) == '1') {
            return ans + 2 * (count - 1);
        }
        return ans + 2 * count - 1;
    }
}