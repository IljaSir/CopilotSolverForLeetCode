class Solution {
    public String baseNeg2(int n) {
        
        String result = "";
        while(n != 0) {
            result = n % 2 + result;
            n = -(n / 2);
        }
        return result.isEmpty() ? "0" : result;
    }
}