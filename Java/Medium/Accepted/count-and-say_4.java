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
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            sb.append(j - i).append(s.charAt(i));
            i = j;
        }
        return sb.toString();
    }
}