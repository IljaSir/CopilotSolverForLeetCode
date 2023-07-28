class Solution {
    public int minimumTime(String s) {
        
        int l = 0, r = s.length() - 1;
        while (l < s.length() && s.charAt(l) == '0') {
            l++;
        }
        while (r >= 0 && s.charAt(r) == '0') {
            r--;
        }
        int res = r - l + 1;
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) == '1') {
                res += 2;
            }
        }
        return res;
    }
}