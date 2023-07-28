class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == c) {
                j++;
            }
            int cnt = j - i;
            if (cnt >= repeatLimit) {
                for (int k = 0; k < repeatLimit; k++) {
                    sb.append(c);
                }
            } else {
                sb.append(s.substring(i, j));
            }
            i = j;
        }
        return sb.toString();
    }
}