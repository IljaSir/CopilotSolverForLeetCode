class Solution {
    public String countAndSay(int n) {
        
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = countAndSay(s);
        }
        return s;
    }
    private String countAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int count = 1;
            i++;
            while (i < s.length() && s.charAt(i) == c) {
                count++;
                i++;
            }
            sb.append(count).append(c);
        }
        return sb.toString();
    }
}