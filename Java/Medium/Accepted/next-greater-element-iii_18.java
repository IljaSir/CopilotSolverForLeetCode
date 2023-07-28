class Solution {
    public int nextGreaterElement(int n) {
        
        char[] chars = String.valueOf(n).toCharArray();
        int i = chars.length - 1;
        while (i > 0 && chars[i] <= chars[i - 1]) {
            i--;
        }
        if (i == 0) {
            return -1;
        }
        int j = chars.length - 1;
        while (j > i - 1 && chars[j] <= chars[i - 1]) {
            j--;
        }
        swap(chars, i - 1, j);
        reverse(chars, i, chars.length - 1);
        long ans = Long.parseLong(new String(chars));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }
}