class Solution {
    public String largestPalindromic(String num) {
        
        int[] count = new int[10];
        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (count[i] > 0) {
                sb.append(i);
                count[i]--;
            }
        }
        return sb.toString();
    }
}