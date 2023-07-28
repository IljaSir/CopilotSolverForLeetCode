class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = i + 1;
        while (i < s.length()) {
            int count = 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                count++;
                j++;
            }
            char c = s.charAt(i);
            for (int k = 0; k < Math.min(count, repeatLimit); k++) {
                sb.append(c);
            }
            i = j;
            j = i + 1;
        }
        return sb.toString();
    }
}