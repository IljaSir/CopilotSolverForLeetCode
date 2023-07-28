class Solution {
    public String abbreviateProduct(int left, int right) {
        
        long product = 1;
        int trailingZeros = 0;
        for (int i = left; i <= right; i++) {
            product *= i;
            while (product % 10 == 0) {
                product /= 10;
                trailingZeros++;
            }
            product %= 100000;
        }
        String s = Long.toString(product);
        if (s.length() > 5) {
            s = s.substring(0, 5) + "..." + s.substring(s.length() - 5);
        }
        return s + "e" + trailingZeros;
    }
}