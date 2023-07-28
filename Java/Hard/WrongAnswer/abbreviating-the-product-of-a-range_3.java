class Solution {
    public String abbreviateProduct(int left, int right) {
        
        int count = 0;
        int product = 1;
        for (int i = left; i <= right; i++) {
            product *= i;
            while (product % 10 == 0) {
                product /= 10;
                count++;
            }
            product %= 100000;
        }
        if (product < 100000) {
            return product + "e" + count;
        } else {
            return product / 10000 + "..." + product % 10000 + "e" + (count + 5);
        }
    }
}