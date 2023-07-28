class Solution {
    public String abbreviateProduct(int left, int right) {
        
        long product = 1;
        int trailingZeros = 0;
        for (int i = left; i <= right; i++) {
            product *= i;
        }
        while (product % 10 == 0) {
            product /= 10;
            trailingZeros++;
        }
        String productStr = String.valueOf(product);
        int len = productStr.length();
        if (len <= 10) {
            return productStr + "e" + trailingZeros;
        }
        return productStr.substring(0, 5) + "..."+ productStr.substring(len - 5) + "e" + trailingZeros;
    }
}