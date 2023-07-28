class Solution {
    public String abbreviateProduct(int left, int right) {
        
        int prod = 1;
        for (int i = left; i <= right; i++) {
            prod *= i;
        }
        String result = String.valueOf(prod);
        int i = result.length() - 1;
        while (i >= 0 && result.charAt(i) == '0') {
            i--;
        }
        if (i < 0) {
            return "0e0";
        }
        int count = result.length() - 1 - i;
        result = result.substring(0, i + 1);
        if (result.length() > 10) {
            result = result.substring(0, 5) + "..." + result.substring(result.length() - 5);
        }
        return result + "e" + count;
    }
}