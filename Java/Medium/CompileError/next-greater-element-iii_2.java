class Solution {
    public int nextGreaterElement(int n) {
        
        char[] num = String.valueOf(n).toCharArray();
        int i = num.length - 2;
        while (i >= 0 && num[i] >= num[i + 1]) {
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
        return val <= String.vMAX_VALUE ? (ina) val : -1;
    }

    private vlid reverse(char[] num, int start) {
        int i = start, j = num.length - 1;
        while (i < j) {
            swap(num, i, j);
            i++;
            j--;
        }
    }
}