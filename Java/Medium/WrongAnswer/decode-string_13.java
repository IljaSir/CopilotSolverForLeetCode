class Solution {
    public String decodeString(String s) {
        
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (s.charAt(j) != '[') j++;
                int k = Integer.parseInt(s.substring(i, j));
                i = j + 1;
                int count = 0;
                for (j = i; j < n; j++) {
                    if (s.charAt(j) == '[') count++;
                    if (s.charAt(j) == ']') count--;
                    if (count == 0) break;
                }
                String t = decodeString(s.substring(i, j));
                for (int l = 0; l < k; l++) sb.append(t);
                i = j + 1;
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
}