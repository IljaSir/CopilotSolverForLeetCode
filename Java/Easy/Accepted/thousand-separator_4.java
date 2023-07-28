class Solution {
    public String thousandSeparator(int n) {
        
        if (n == 0) return "0";
        int count = 0;
        String str = "";
        while (n > 0) {
            if (count == 3) {
                str = "." + str;
                count = 0;
            }
            str = (n % 10) + str;
            n /= 10;
            count++;
        }
        return str;
    }
}