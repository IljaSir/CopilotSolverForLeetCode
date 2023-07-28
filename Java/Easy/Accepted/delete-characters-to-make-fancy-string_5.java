class Solution {
    public String makeFancyString(String s) {
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char last = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == last) {
                count++;
            } else {
                last = c;
                count = 1;
            }
            if (count < 3) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}