class Solution {
    public String abbreviateProduct(int left, int right) {
        
        long product = 1;
        for (int i = left; i <= right; i++) {
            product *= i;
        }
        int trailingZeros = 0;
        while (product % 10 == 0) {
            trailingZeros++;
            product /= 10;
        }
        String productString = String.valueOf(product);
        if (productString.length() > 10) {
            productString = productString.substring(0, 5) + "..." + productString.substring(productString.length() - 5);
        }
        if (trailingZeros > 0) {
            productString += "e" + trailingZeros;
        }
        return productString;
    }
}