class Solution {
    public char findKthBit(int n, int k) {
        
        return findKthBit(n, k, new StringBuilder());
    }
    private char findKthBit(int n, int k, StringBuilder sb) {
        if (n == 1) {
            sb.append("0");
            return sb.charAt(k - 1);
        }
        int len = (int) Math.pow(2, n) - 1;
        if (k == len / 2 + 1) {
            sb.append("1");
            return '1';
        }
        if (k <= len / 2) {
            return findKthBit(n - 1, k, sb);
        }
        return findKthBit(n - 1, len - k + 1, sb);
    }
}