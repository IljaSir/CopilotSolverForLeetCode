class Solution {
    public String thousandSeparator(int n) {
        
        if (n == 0) {
            return "0";
        }
        String num = String.valueOf(n);
        int len = num.length();
        if (len <= 3) {
            return num;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < len) {
            if (i % 3 == 0 && i != 0) {
                sb.append(".");
            }
            sb.append(num.charAt(i));
            i++;
        }
        return sb.toString();
    }
}