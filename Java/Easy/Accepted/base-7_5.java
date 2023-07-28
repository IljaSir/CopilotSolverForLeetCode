class Solution {
    public String convertToBase7(int num) {
        
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (isNegative) sb.append("-");
        return sb.reverse().toString();
    }
}