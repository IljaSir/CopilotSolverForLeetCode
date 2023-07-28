class Solution {
    public String makeFancyString(String s) {
        
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                sb.append(c);
            } else {
                char last = sb.charAt(sb.length() - 1);
                if (last == c) {
                    count++;
                    if (count < 3) {
                        sb.append(c);
                    }
                } else {
                    sb.append(c);
                    count = 1;
                }
            }
        }
        return sb.toString();
    }
}