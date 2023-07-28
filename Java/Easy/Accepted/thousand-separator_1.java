class Solution {
    public String thousandSeparator(int n) {
        
        String s = Integer.toString(n);
        String ans = "";
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            ans = s.charAt(i) + ans;
            count++;
            if (count == 3 && i != 0) {
                ans = "." + ans;
                count = 0;
            }
        }
        return ans;
    }
}