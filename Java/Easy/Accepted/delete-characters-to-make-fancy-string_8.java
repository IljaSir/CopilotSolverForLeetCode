class Solution {
    public String makeFancyString(String s) {
        
        int count = 0;
        char last = ' ';
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != last) {
                count = 1;
                last = c;
                sb.append(c);
            } else {
                count++;
                if (count < 3) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}