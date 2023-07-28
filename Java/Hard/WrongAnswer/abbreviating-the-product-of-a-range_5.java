class Solution {
    public String abbreviateProduct(int left, int right) {
        
        long prod = 1;
        int exp = 0;
        for (int i = left; i <= right; i++) {
            prod *= i;
            while (prod % 10 == 0) {
                prod /= 10;
                exp++;
            }
            prod %= 100000;
        }
        if (prod < 100000) {
            return prod + "e" + exp;
        }
        return prod / 1000 + "..." + prod % 1000 + "e" + (exp + 3);
    }
}