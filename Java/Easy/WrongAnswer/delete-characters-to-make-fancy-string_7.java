class Solution {
    public String makeFancyString(String s) {
        
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == last) {
                ++count;
                if (count < 3) {
                    sb.append(s.charAt(i));
                }
            } else {
                count = 1;
                last = s.charAt(i);
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}