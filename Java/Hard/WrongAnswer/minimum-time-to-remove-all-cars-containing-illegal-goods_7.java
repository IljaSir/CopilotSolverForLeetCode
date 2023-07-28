class Solution {
    public int minimumTime(String s) {
        
        int n = s.length();
        int count = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') count++;
            else {
                if (count > 0) {
                    if (i == n - 1 || s.charAt(i + 1) == '0') {
                        res += 2;
                        count = 0;
                    }
                }
            }
        }
        return res + count;
    }
}