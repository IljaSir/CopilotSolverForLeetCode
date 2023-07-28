class Solution {
    public String robotWithString(String s) {
        
        int n = s.length();
        char[] ans = new char[n];
        int i = 0;
        int j = n - 1;
        int k = n - 1;
        while (i <= j) {
            boolean left = false;
            for (int p = 0; i + p <= j; p++) {
                if (s.charAt(i + p) < s.charAt(j - p)) {
                    left = true;
                    break;
                } else if (s.charAt(i + p) > s.charAt(j - p)) {
                    left = false;
                    break;
                }
            }
            if (left) {
                ans[k--] = s.charAt(i++);
            } else {
                ans[k--] = s.charAt(j--);
            }
        }
        return new String(ans);
    }
}