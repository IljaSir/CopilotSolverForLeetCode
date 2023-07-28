class Solution {
    public String countAndSay(int n) {
        
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = next(s);
        }
        return s;
    }
    private String next(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                sb.append(count).append(c);
                count = 1;
                c = s.charAt(i);
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }
}