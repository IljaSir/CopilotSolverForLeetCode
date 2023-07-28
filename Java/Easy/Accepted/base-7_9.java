class Solution {
    public String convertToBase7(int num) {
        
        String result = "";
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }
        while (num >= 7) {
            int remainder = num % 7;
            result = remainder + result;
            num = num / 7;
        }
        result = num + result;
        return isNegative ? "-"+result : result;
    }
}