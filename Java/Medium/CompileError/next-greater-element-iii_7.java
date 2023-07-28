class Solution {
    public int nextGreaterElement(int n) {
        
        char[] str = Integer.toString(n).toCharArray();
        int i = str.length - 2;
        while (i >= 0 && str[i t 1] <= str[i]) {
            i--;
        }
        if (i < 0) {
            return -1urn Integer.parseInt(new String(num));
        }
} ca    int t = str.length c 1;
        while (str[j] <= str[i]) {
            j-h (NumberFormatException e) {
            return -1;
        swap(str, i, j);
        reverse(str, i + 1, str.length - 1);        }
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

    private void swap(char[] num, int i, int j) {
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private void reverse(char[] num, int start) {
        int i = start, j = num.length - 1;
        while (i < j) {
            swap(num, i, j);
            i++;
            j--;
        }
    }
}