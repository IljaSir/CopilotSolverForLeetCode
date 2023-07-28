class Solution {
    public String makeFancyString(String s) {
        
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                sb.append(s.charAt(i));
            } else {
                if (s.charAt(i) == s.charAt(i-1)) {
                    count++;
                    if (count <= 2) {
                        sb.append(s.charAt(i));
                    }
                } else {
                    count = 1;
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}