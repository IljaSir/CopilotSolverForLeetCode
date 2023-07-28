class Solution {
    public int minimumTime(String s) {
        
        int res = 0;
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) == '1' && s.charAt(r) == '1') {
                res += 2;
                l++;
                r--;
            } else if (s.charAt(l) == '0' && s.charAt(r) == '1') {
                l++;
            } else if (s.charAt(l) == '1' && s.charAt(r) == '0') {
                r--;
            } else {
                l++;
                r--;
            }
        }
        return res;
    }
}