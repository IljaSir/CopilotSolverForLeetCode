class Solution {
    public int getKth(int lo, int hi, int k) {
        
        int[] arr = new int[hi - lo + 1];
        int[] power = new int[hi - lo + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lo + i;
            power[i] = getPower(arr[i]);
        }
        quickSort(arr, power, 0, arr.length - 1);
        return arr[k - 1];
    }
    
    public int getPower(int x) {
        int count = 0;
        while (x != 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = 3 * x + 1;
            }
            count++;
        }
        return count;
    }
    
    public void quickSort(int[] arr, int[] power, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, power, start, end);
            quickSort(arr, power, start, pivot - 1);
            quickSort(arr, power, pivot + 1, end);
        }
    }
    
    public int partition(int[] arr, int[] power, int start, int end) {
        int pivot = power[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (power[j] < pivot || (power[j] == pivot && arr[j] < arr[end])) {
                i++;
                swap(arr, power, i, j);
            }
        }
        swap(arr, power, i + 1, end);
        return i + 1;
    }
}