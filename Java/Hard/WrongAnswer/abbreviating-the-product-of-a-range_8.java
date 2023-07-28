class Solution {
    public String abbreviateProduct(int left, int right) {
        
        if (left == right) {
            return String.valueOf(left);
        }
        if (left + 1 == right) {
            return String.valueOf(left * right);
        }
        return "e" + String.valueOf(right - left + 1);
    }
}