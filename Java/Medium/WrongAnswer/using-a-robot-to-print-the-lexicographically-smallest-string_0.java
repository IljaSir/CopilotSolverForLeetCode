class Solution {
    public String robotWithString(String s) {
        
        int n = s.length();
        int i = 0, j = n - 1;
        StringBuilder sb = new StringBuilder();
        while (i <= j) {
            boolean left = false;
            for (int k = 0; i + k <= j; k++) {
                if (s.charAt(i + k) < s.charAt(j - k)) {
                    left = true;
                    break;
                } else if (s.charAt(i + k) > s.charAt(j - k)) {
                    left = false;
                    break;
                }
            }
            if (left) sb.append(s.charAt(i++));
            else sb.append(s.charAt(j--));
        }
        return sb.toString();
    }
}