class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for (int i = n; i > 0; i--) {
            int j = 0;
            while (arr[j] != i) {
                j++;
            }
            res.add(j + 1);
            res.add(i);
            reverse(arr, j + 1);
            reverse(arr, i);
        }
        return res;
    }

    private void reverse(int[] arr, int k) {
        int i = 0;
        int j = k - 1;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}