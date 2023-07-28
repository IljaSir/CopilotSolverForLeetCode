class Solution {
    public int nextGreaterElement(int n) {
        
        char[] chars = String.valueOf(n).toCharArray();
        int i = chars.length - 1;
        while (i > 0 && chars[i] <= chars[i - 1]) i--;
        if (i == 0) return -1;
        int j = chars.length - 1;
        while (chars[j] <= chars[i - 1]) j--;
        swap(chars, i - 1, j);
        reverse(chars, i, chars.length - 1);
        long res = Long.parseLong(new String(chars));
        return res > Integer.MAX_VALUE ? -1 : (int)res;
    }
    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}