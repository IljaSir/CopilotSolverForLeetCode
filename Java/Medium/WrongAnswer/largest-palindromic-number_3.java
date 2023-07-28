class Solution {
    public String largestPalindromic(String num) {
        
        char[] chars = num.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != '0') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}