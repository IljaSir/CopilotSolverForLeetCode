class Solution {
    public String countAndSay(int n) {
        
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = countAndSay(s);
        }
        return s;
    }
    public String countAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(count).append(s.charAt(i));
                count = 1;
            } else {
                count++;
            }
        }
        return sb.toString();
    }
}