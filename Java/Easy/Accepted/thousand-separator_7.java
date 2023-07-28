class Solution {
    public String thousandSeparator(int n) {
        
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        int i = s.length();
        while (i > 3) {
            sb.insert(0, s.substring(i - 3, i));
            sb.insert(0, ".");
            i -= 3;
        }
        sb.insert(0, s.substring(0, i));
        return sb.toString();
    }
}