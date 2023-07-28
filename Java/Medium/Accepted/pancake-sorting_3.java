class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = arr.length; i > 0; i--) {
            int index = find(arr, i);
            if (index != i - 1) {
                reverse(arr, index);
                result.add(index + 1);
                reverse(arr, i - 1);
                result.add(i);
            }
        }
        return result;
    }
    private int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    private void reverse(int[] arr, int end) {
        int start = 0;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}