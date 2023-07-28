class Solution {
    public String reverseStr(String s, int k) {
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            reverse(chars, i, Math.min(i + k - 1, chars.length - 1));
        }
        return new String(chars);
    }
    
    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char tmp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = tmp;
        }
    }
}