class Solution {
    public String baseNeg2(int n) {
        
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(Math.abs(n % -2));
            n = (n - n % -2) / -2;
        }
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}