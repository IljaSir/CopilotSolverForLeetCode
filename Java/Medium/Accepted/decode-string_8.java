class Solution {
    public String decodeString(String s) {
        
        return decodeString(s, 0, s.length());
    }

    private String decodeString(String s, int start, int end) {
        int i = start;
        StringBuilder sb = new StringBuilder();
        while (i < end) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int count = 0;
                while (c >= '0' && c <= '9') {
                    count = count * 10 + (c - '0');
                    c = s.charAt(++i);
                }
                int j = i + 1;
                int count2 = 1;
                while (count2 > 0) {
                    if (s.charAt(j) == '[') {
                        count2++;
                    } else if (s.charAt(j) == ']') {
                        count2--;
                    }
                    j++;
                }
                String str = decodeString(s, i + 1, j - 1);
                while (count-- > 0) {
                    sb.append(str);
                }
                i = j;
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
}