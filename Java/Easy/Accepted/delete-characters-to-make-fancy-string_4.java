class Solution {
    public String makeFancyString(String s) {
        
        int n = s.length();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            if (count < 3) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}