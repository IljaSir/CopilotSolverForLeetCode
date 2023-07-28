class Solution {
    public String thousandSeparator(int n) {
        
        String s = Integer.toString(n);
        int len = s.length();
        String ans = "";
        int i = 0;
        while (i < len) {
            if (i > 0 && (len - i) % 3 == 0) {
                ans += ".";
            }
            ans += s.charAt(i);
            i++;
        }
        return ans;
    }
}