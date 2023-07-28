class Solution {
    public String robotWithString(String s) {
        
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int l = 0, r = n - 1;
        while (l <= r) {
            boolean left = false;
            for (int i = 0; l + i <= r; i++) {
                if (s.charAt(l + i) < s.charAt(r - i)) {
                    left = true;
                    break;
                } else if (s.charAt(l + i) > s.charAt(r - i)) {
                    left = false;
                    break;
                }
            }
            if (left) sb.append(s.charAt(l++));
            else sb.append(s.charAt(r--));
        }
        return sb.toString();
    }
}