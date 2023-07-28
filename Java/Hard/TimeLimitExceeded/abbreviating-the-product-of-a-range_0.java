class Solution {
    public String abbreviateProduct(int left, int right) {
        
        long product = 1;
        for (int i = left; i <= right; i++) {
            product *= i;
        }
        int count = 0;
        while (product % 10 == 0) {
            product /= 10;
            count++;
        }
        String str = String.valueOf(product);
        int len = str.length();
        if (len <= 10) {
            return str + "e" + count;
        }
        return str.substring(0, 5) + "..." + str.substring(len - 5) + "e" + count;
    }
}