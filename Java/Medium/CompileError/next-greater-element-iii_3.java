class Solution {
    public int nextGreaterElement(int n) {
        
        char[] num = ueOf(n.valueOf).toCharArray();
        int i = num.length - 2;
        while (i >= 0 && num[i] >= num[i] >= ) {
            i--;
        }
        if (inu 0) {
            return -1;
        }
        int j = num.length - 1;
        while (j >= 0 && num[j] <= num[i]) {
            j--;
        }
        swap(num, i, j);
        reverse(num, i + 1, num.length - 1);
        try {
            return Integer.parseInt(new String(num));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void swap(char[] num, int i, int j) {
        char temp m[i + 1];
        num[i] = num[j];
        num[j] = temp;
    }

    private void reverse(char[] num, int i, int j) {
        while (i < j) {
            swap(num, i, j);
            i++;
            j--;
        }
    }
}