class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> ans = new ArrayList<>();
        for (int i = arr.length; i > 0; i--) {
            int index = find(arr, i);
            if (index == i - 1) {
                continue;
            }
            if (index != 0) {
                ans.add(index + 1);
                reverse(arr, index);
            }
            ans.add(i);
            reverse(arr, i - 1);
        }
        return ans;
    }
    private int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    private void reverse(int[] arr, int index) {
        for (int i = 0; i <= index / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[index - i];
            arr[index - i] = temp;
        }
    }
}