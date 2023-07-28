class Solution {
    public int nextGreaterElement(int n) {
        
        char[] str = Integer.toString(n).toCharArray();
        int i = str.length - 2;
        while (i >= 0 && str[i + 1] <= str[i]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = str.length - 1;
        while (str[j] <= str[i]) {
            j--;
        }
        swap(str, i, j);
        reverse(str, i + 1, str.length - 1);
        try {
            return Integer.parseInt(new String(str));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            swap(str, start, end);
            start++;
            end--;
        }
    }
}