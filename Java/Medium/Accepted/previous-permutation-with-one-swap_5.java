class Solution {
    public int[] prevPermOpt1(int[] arr) {
        
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int j = i + 1;
                while (j + 1 < n && arr[j + 1] < arr[i]) {
                    j++;
                }
                while (j > i + 1 && arr[j] == arr[j - 1]) {
                    j--;
                }
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                break;
            }
        }
        return arr;
    }
}