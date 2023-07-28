class Solution {
    public String thousandSeparator(int n) {
        
        String num = String.valueOf(n);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            sb.append(num.charAt(i));
            count++;
            if (count == 3 && i != 0) {
                sb.append(".");
                count = 0;
            }
        }
        return sb.reverse().toString();
    }
}