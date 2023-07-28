class Solution {
    public String abbreviateProduct(int left, int right) {
        
        long product = 1;
        int trailingZeros = 0;
        for (int i = left; i <= right; i++) {
            int num = i;
            while (num % 10 == 0) {
                num /= 10;
                trailingZeros++;
            }
            product *= num;
        }
        String productString = product + "";
        int digits = productString.length();
        if (digits > 10) {
            productString = productString.substring(0, 5) + "..." + productString.substring(digits - 5);
        }
        if (trailingZeros > 0) {
            productString += "e" + trailingZeros;
        }
        return productString;
    }
}