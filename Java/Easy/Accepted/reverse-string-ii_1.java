class Solution {
    public String reverseStr(String s, int k) {
        
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i += 2 * k) {
            int j = Math.min(i + k - 1, n - 1);
            swap(chars, i, j);
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