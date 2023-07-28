class Solution {
    public String convertToBase7(int num) {
        
        String result = "";
        int n = Math.abs(num);
        while (n >= 7) {
            result = (n % 7) + result;
            n /= 7;
        }
        result = n + result;
        return num < 0 ? "-" + result : result;
    }
}