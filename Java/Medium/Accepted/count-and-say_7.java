class Solution {
    public String countAndSay(int n) {
        
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = countAndSay(s);
        }
        return s;
    }
    
    String countAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 1;
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            } else {
                sb.append(j - i);
                sb.append(s.charAt(i));
                i = j;
                j++;
            }
        }
        sb.append(j - i);
        sb.append(s.charAt(i));
        return sb.toString();
    }
}