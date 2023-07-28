class Solution {
    public String convertToBase7(int num) {
        
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            sb.append("-");
            num = -num;
        }
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        return sb.reverse().toString();
    }
}