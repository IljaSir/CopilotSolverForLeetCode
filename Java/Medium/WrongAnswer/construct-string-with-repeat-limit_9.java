class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        // if (s.length() == 1) {
        //     return s;
        // }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int count = 1;
        char prev = s.charAt(0);
        sb.append(prev);
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == prev) {
                count++;
                if (count <= repeatLimit) {
                    sb.append(c);
                }
            } else {
                count = 1;
                prev = c;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}