class Solution {
    public int nextGreaterElement(int n) {
        
        char[] num = Integer.toString(n).toCharArray();
        int i = num.length - 2;
        while (i >= 0 && num[i + 1] <= num[i]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = num.length - 1;
        while (j >= 0 && num[j] <= num[i]) {
            j--;
        }
        swap(num, i, j);
        reverse(num, i + 1);
        long val = Long.parseLong(String.valueOf(num));
        return val <= Integer.MAX_VALUE ? (int) val : -1;
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