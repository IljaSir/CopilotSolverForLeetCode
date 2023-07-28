class Solution {
    public String reverseStr(String s, int k) {
        
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            int j = Math.min(i + k - 1, chars.length - 1);
            swap(chars, i, j);
            i += 2 * k;
        }
        return new String(chars);
    }
    
    private void swap(char[] chars, int i, int j) {
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }
}