class Solution {
    public String thousandSeparator(int n) {
        
        if (n == 0) return "0";
        String s = "";
        int count = 0;
        while (n > 0) {
            if (count == 3) {
                s = "." + s;
                count = 0;
            }
            s = (n % 10) + s;
            n /= 10;
            count++;
        }
        return s;
    }
}