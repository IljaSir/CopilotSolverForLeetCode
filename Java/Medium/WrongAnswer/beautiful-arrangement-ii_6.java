class Solution {
    public int[] constructArray(int n, int k) {
        
        int[] arr = new int[n];
        int i = 0, j = n;
        while (i < j) {
            if (k > 1) {
                arr[i++] = k-- % 2 == 1 ? j-- : i++;
            } else {
                arr[i++] = j--;
            }
        }
        return arr;
    }
}