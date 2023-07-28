class Solution {
    public String thousandSeparator(int n) {
        
        String s = String.valueOf(n);
        int l = s.length();
        if (l <= 3) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            if (i > 0 && (l - i) % 3 == 0) {
                sb.append(".");
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}