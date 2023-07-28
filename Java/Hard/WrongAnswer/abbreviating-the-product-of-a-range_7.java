class Solution {
    public String abbreviateProduct(int left, int right) {
        
        long product = 1;
        for (int i = left; i <= right; i++) {
            product *= i;
        }
        String productString = String.valueOf(product);
        int length = productString.length();
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (productString.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }
        if (count == 0) {
            return productString + "e0";
        }
        if (length - count <= 10) {
            return productString.substring(0, length - count) + "e" + count;
        }
        return productString.substring(0, 5) + "..." + productString.substring(length - count - 5, length - count) + "e" + count;
    }
}