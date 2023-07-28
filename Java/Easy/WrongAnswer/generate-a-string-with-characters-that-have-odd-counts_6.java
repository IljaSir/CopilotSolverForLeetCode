class Solution {
    public String generateTheString(int n) {
        
        if (n == 1) {
            return "a";
        }
        if (n % 2 == 0) {
            return "a" + generateTheString(n - 1);
        }
        return "b" + generateTheString(n - 1);
    }
}