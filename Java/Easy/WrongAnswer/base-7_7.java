class Solution {
    public String convertToBase7(int num) {
        
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (negative) {
            sb.append('-');
        }
        sb.reverse();
        return sb.toString();
    }
}