class Solution {
    public String smallestNumber(String pattern) {
        
        int n = pattern.length();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = n;
        for (int i = 0; i < n; i++) {
            if (pattern.charAt(i) == 'I') {
                sb.append(start++);
            } else {
                sb.append(end--);
            }
        }
        sb.append(start);
        return sb.toString();
    }
}