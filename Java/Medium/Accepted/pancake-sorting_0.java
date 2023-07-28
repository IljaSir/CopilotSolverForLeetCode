class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = i + 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != sorted[i]) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] == sorted[i]) {
                        flip(arr, j);
                        result.add(j + 1);
                        break;
                    }
                }
                flip(arr, i);
                result.add(i + 1);
            }
        }
        return result;
    }

    private void flip(int[] arr, int k) {
        for (int i = 0, j = k; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}