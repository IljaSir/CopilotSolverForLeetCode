class Solution {
    public int getMinSwaps(String num, int k) {
        
        char[] arr = num.toCharArray();
        for (int i = 0; i < k; i++) {
            nextPermutation(arr);
        }
        int res = 0;
        for (int i = 0; i < num.length(); i++) {
            if (arr[i] != num.charAt(i)) {
                for (int j = i + 1; j < num.length(); j++) {
                    if (arr[j] == num.charAt(i)) {
                        while (j > i) {
                            swap(arr, j, j - 1);
                            j--;
                            res++;
                        }
                        break;
                    }
                }
            }
        }
        return res;
    }
    
    private void nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i >= 0) {
            int j = arr.length - 1;
            while (j >= 0 && arr[j] <= arr[i]) j--;
            swap(arr, i, j);
        }
        reverse(arr, i + 1);
    }
    
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    private void reverse(char[] arr, int start) {
        int i = start, j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}