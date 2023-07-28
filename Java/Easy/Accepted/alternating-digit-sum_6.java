class Solution {
    public int alternateDigitSum(int n) {
        
        String num = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            if (i % 2 == 0) {
                sum += digit;
            } else {
                sum -= digit;
            }
        }
        return sum;
    }
}