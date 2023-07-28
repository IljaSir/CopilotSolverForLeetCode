class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for (int i = n - 1; i >= 1; i--) {
            int index = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[j] == i + 1) {
                    index = j;
                    break;
                }
            }
            if (index == i) {
                continue;
            }
            if (index != 0) {
                res.add(index + 1);
                reverse(arr, index + 1);
            }
            res.add(i + 1);
            reverse(arr, i + 1);
        }
        return res;
    }

    private void reverse(int[] arr, int k) {
        int i = 0, j = k - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}